
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.ssl.ApplicationProtocolNegotiationHandler;

public class DefaultChooser extends ApplicationProtocolNegotiationHandler {

    /**
     * Creates a new instance with the specified fallback protocol name.
     *
     * @param fallbackProtocol the name of the protocol to use when
     *                         ALPN/NPN negotiation fails or the client does not support ALPN/NPN
     */
    protected DefaultChooser(String fallbackProtocol) {
        super(fallbackProtocol);
    }

    @Override
    protected void configurePipeline(ChannelHandlerContext ctx, String protocol) throws Exception {
        ChannelPipeline pipeline = ctx.pipeline();
        switch(protocol) {
            case "http/1.1":
                pipeline.addLast(new HttpRequestHandler());
                break;
            case "spdy/2":
            case"spdy/3":
                pipeline.addLast(new SpdyRequestHandler());
            default:
                pipeline.addLast(new HttpRequestHandler());
                break;
        }
    }
}
