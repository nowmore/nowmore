import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {

    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {
        ByteBuf data = msg.content();
        int i = data.indexOf(0, data.readableBytes(), LogEvent.SEPARATOR);
        String file = data.slice(0, i).toString(CharsetUtil.UTF_8);
        String content = data.slice(i + 1, data.readableBytes()).toString(CharsetUtil.UTF_8);

        LogEvent event = new LogEvent(msg.recipient(), file, content, System.currentTimeMillis());

        out.add(event);
    }
}
