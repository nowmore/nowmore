import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

public class MemcachedRequestEncoder extends MessageToByteEncoder<MemcachedRequest> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MemcachedRequest msg, ByteBuf out) throws Exception {
        byte[] key = msg.key().getBytes(CharsetUtil.UTF_8);
        byte[] body = msg.body().getBytes(CharsetUtil.UTF_8);

        int extrasSize = msg.hasExtras() ? 0x08 : 0x00;
        int bodySize = key.length + body.length + extrasSize;

        out.writeByte(msg.magic());
        out.writeByte(msg.opCode());
        out.writeShort(key.length);
        out.writeByte(extrasSize);
        out.writeByte(0);
        out.writeShort(0);
        out.writeInt(bodySize);
        out.writeInt(msg.id());
        out.writeLong(msg.cas());

        if(msg.hasExtras()) {
            out.writeInt(msg.flags());
            out.writeInt(msg.expires());
        }

        out.writeBytes(key);
        out.writeBytes(body);

    }
}
