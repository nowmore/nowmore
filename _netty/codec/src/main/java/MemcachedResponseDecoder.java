import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class MemcachedResponseDecoder extends ByteToMessageDecoder {

    private enum State {
        Header,
        Body
    }

    private State state = State.Header;
    private int totalBodySize;
    private byte magic;
    private byte opCode;
    private short keyLength;
    private byte extrasLength;
    private byte dataType;
    private short status;
    private int id;
    private long cas;


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        switch(state) {
            case Header:
                if(in.readableBytes() < 24) {
                    return;
                }

                magic = in.readByte();
                opCode = in.readByte();
                keyLength = in.readShort();
                extrasLength = in.readByte();
                dataType = in.readByte();
                //in.skipBytes(1);
                status = in.readShort();
                totalBodySize = in.readInt();
                id = in.readInt();
                cas = in.readLong();

                state = State.Body;
            case Body:
                if(in.readableBytes() < totalBodySize) {
                    return;
                }
                int flags = 0, expires = 0;

                int actualBodySize = totalBodySize;
                if(extrasLength > 0) {
                    flags = in.readInt();
                    actualBodySize -= 4;
                }
                if(extrasLength > 4) {
                    expires = in.readInt();
                    actualBodySize -= 4;
                }

                String key = "";
                if(keyLength > 0) {
                    ByteBuf keyBytes = in.readBytes(keyLength);
                    key = keyBytes.toString(CharsetUtil.UTF_8);
                    actualBodySize -= keyLength;
                }

                ByteBuf body = in.readBytes(actualBodySize);
                String data = body.toString(CharsetUtil.UTF_8);

                out.add(new MemcachedResponse(
                        magic,
                        opCode,
                        dataType,
                        status,
                        id,
                        cas,
                        flags,
                        expires,
                        key,
                        data
                ));
                state = State.Header;
                break;
            default:
                break;
        }
    }
}
