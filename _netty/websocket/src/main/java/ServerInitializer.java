import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


public class ServerInitializer extends ChannelInitializer<Channel> {
    private final ChannelGroup channels;

    public ServerInitializer(ChannelGroup channels) {
        this.channels = channels;
    }

    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        p.addLast(
                new HttpServerCodec(),
                new HttpObjectAggregator(64 * 1024),
                new ChunkedWriteHandler(),
                new HttpRequestHandler("/ws"),
                new WebSocketServerProtocolHandler("/ws"),
                new TextWebSocketFrameHandler(channels)
        );
    }
}
