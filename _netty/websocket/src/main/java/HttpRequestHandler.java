import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;

import java.io.File;
import java.io.RandomAccessFile;

public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final String uri;
    private static final File INDEX;

    public HttpRequestHandler(String uri) {
        this.uri = uri;
    }

    static {
        try {
            INDEX = new File("./index.html");
        } catch (Exception e) {
            throw new IllegalStateException("Unable to locate index.html", e);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
        if(uri.equalsIgnoreCase(req.uri())) {
            ctx.fireChannelRead(req.retain());
        } else {
            if(HttpUtil.is100ContinueExpected(req)) {
                send100Continue(ctx);
            }

            RandomAccessFile file = new RandomAccessFile(INDEX, "r");

            HttpResponse rsp = new DefaultHttpResponse(req.protocolVersion(), HttpResponseStatus.OK);
            rsp.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");

            boolean keepAlive = HttpUtil.isKeepAlive(req);

            if(keepAlive) {
                rsp.headers().set(HttpHeaderNames.CONTENT_LENGTH, file.length());
                rsp.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            }

            ctx.write(rsp);

            if(ctx.pipeline().get(SslHandler.class) == null) {
                ctx.write(new DefaultFileRegion(file.getChannel(), 0, file.length()));
            } else {
                ctx.write(new ChunkedNioFile(file.getChannel()));
            }

            ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
            if(!keepAlive) {
                future.addListener(ChannelFutureListener.CLOSE);
            }
        }
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
