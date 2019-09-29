import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.util.CharsetUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CodecTest {

    @Test
    public void testEncoder() {
        MemcachedRequest req = new MemcachedRequest(Opcode.SET, "key1", "value1");
        EmbeddedChannel channel = new EmbeddedChannel(new MemcachedRequestEncoder());

        channel.writeOutbound(req);

        ByteBuf encoded = (ByteBuf) channel.readOutbound();
        Assert.assertNotNull(encoded);
        Assert.assertEquals(req.magic(), encoded.readUnsignedByte());
        Assert.assertEquals(req.opCode(), encoded.readByte());
        Assert.assertEquals(4, encoded.readShort());
        Assert.assertEquals((byte)0x08, encoded.readByte());
        Assert.assertEquals((byte)0, encoded.readByte());
        Assert.assertEquals(0, encoded.readShort());
        Assert.assertEquals(4 + 6 + 8, encoded.readInt());
        Assert.assertEquals(req.id(), encoded.readInt());
        Assert.assertEquals(req.cas(), encoded.readLong());
        Assert.assertEquals(req.flags(), encoded.readInt());
        Assert.assertEquals(req.expires(), encoded.readInt());

        byte[] data =  new byte[encoded.readableBytes()];

        encoded.readBytes(data);

        Assert.assertArrayEquals((req.key() + req.body()).getBytes(CharsetUtil.UTF_8), data);

        Assert.assertFalse(encoded.isReadable());
        Assert.assertFalse(channel.finish());
        Assert.assertNull(channel.readInbound());

    }

    @Test
    public void testDecoder() {
        EmbeddedChannel channel = new EmbeddedChannel(new MemcachedResponseDecoder());

        byte magic = 1;
        byte opCode = Opcode.SET;

        byte[] key = "Key1".getBytes(CharsetUtil.UTF_8);
        byte[] body = "Value".getBytes(CharsetUtil.UTF_8);
        byte dataType =0;
        int id = (int) System.currentTimeMillis();
        long cas = System.currentTimeMillis();

        ByteBuf buf = Unpooled.buffer();
        buf.writeByte(magic);
        buf.writeByte(opCode);
        buf.writeShort(key.length);
        buf.writeByte(0);
        buf.writeByte(dataType);
        buf.writeShort(Status.KEY_EXISTS);
        buf.writeInt(body.length + key.length);
        buf.writeInt(id);
        buf.writeLong(cas);
        buf.writeBytes(key);
        buf.writeBytes(body);

        Assert.assertTrue(channel.writeInbound(buf));

        MemcachedResponse rsp = (MemcachedResponse) channel.readInbound();
        assertResponse(rsp, magic, opCode, Status.KEY_EXISTS, 0, 0, id, cas, key, body);
    }

    @Test
    public void testDecoderFragments() {
        EmbeddedChannel channel = new EmbeddedChannel(new MemcachedResponseDecoder());

        byte magic = 1;
        byte opCode = Opcode.SET;
        byte[] key = "Key2".getBytes(CharsetUtil.UTF_8);
        byte[] body = "Value2".getBytes(CharsetUtil.UTF_8);
        int id = (int) System.currentTimeMillis() + 1;
        long cas = System.currentTimeMillis() + 2;


        ByteBuf buf = Unpooled.buffer();
        buf.writeByte(magic);
        buf.writeByte(opCode);
        buf.writeShort(key.length);
        buf.writeByte(0);
        buf.writeByte(0);
        buf.writeShort(Status.KEY_EXISTS);
        buf.writeInt(body.length + key.length);
        buf.writeInt(id);
        buf.writeLong(cas);
        buf.writeBytes(key);
        buf.writeBytes(body);

        ByteBuf fragment1 = buf.readBytes(8);
        ByteBuf fragment2 = buf.readBytes(24);
        ByteBuf fragment3 = buf;

        Assert.assertFalse(channel.writeInbound(fragment1));
        Assert.assertFalse(channel.writeInbound(fragment2));
        Assert.assertTrue(channel.writeInbound(fragment3));

        MemcachedResponse rsp = (MemcachedResponse) channel.readInbound();
        assertResponse(rsp, magic, opCode, Status.KEY_EXISTS, 0, 0, id, cas, key, body);
    }

    private static void assertResponse(MemcachedResponse rsp, byte magic, byte opCode, short status, int expires,
    int flags, int id, long cas, byte[] key, byte[] body) {
        Assert.assertEquals(magic, rsp.magic());
        Assert.assertArrayEquals(key, rsp.key().getBytes(CharsetUtil.UTF_8));
        Assert.assertEquals(opCode, rsp.opCode());
        Assert.assertEquals(status, rsp.status());
        Assert.assertEquals(cas, rsp.cas());
        Assert.assertEquals(expires, rsp.expires());
        Assert.assertEquals(flags, rsp.flags());
        Assert.assertArrayEquals(body, rsp.data().getBytes(CharsetUtil.UTF_8));
        Assert.assertEquals(id, rsp.id());
    }
}
