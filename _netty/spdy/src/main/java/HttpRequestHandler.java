import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
        if(HttpHeaders.is100ContinueExpected(req)) {
            send100Continue(ctx);
        }

        FullHttpResponse rsp = new DefaultFullHttpResponse(req.getProtocolVersion(), HttpResponseStatus.OK);
        rsp.content().writeBytes(getContent().getBytes(CharsetUtil.UTF_8));
        rsp.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/plain; charset=UTF-8");

        boolean keepAlive = HttpHeaders.isKeepAlive(req);

        if(keepAlive) {
            rsp.headers().set(HttpHeaders.Names.CONTENT_LENGTH, rsp.content().readableBytes());
            rsp.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }

        ChannelFuture future = ctx.writeAndFlush(rsp);

        if(!keepAlive) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    protected String getContent() {
        return "This content is transmitted via HTTP\r\n";
    }

    private static void send100Continue(ChannelHandlerContext ctx) {
        FullHttpResponse rsp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE);
        ctx.writeAndFlush(rsp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        if(ctx.channel().isActive()) {
            ctx.close();
        }
    }
}
