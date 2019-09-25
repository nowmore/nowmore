import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;

public class app {

    private final ChannelGroup channels = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);
    private final EventLoopGroup executors = new NioEventLoopGroup();
    private Channel channel;

    public ChannelFuture start(int port) {
        ServerBootstrap b = new ServerBootstrap();

        b.group(executors)
                .channel(NioServerSocketChannel.class)
                .childHandler(createInitializer(channels));

        ChannelFuture f = b.bind(port);
        f.syncUninterruptibly();
        channel = f.channel();
        return f;
    }

    protected ChannelInitializer createInitializer(ChannelGroup channels) {
        return new ServerInitializer(channels);
    }


    public void destroy() {
        if(channel != null) {
            channel.close();
        }

        channels.close();
        executors.shutdownGracefully();
    }

    public static void main(String[] args) {
        final app a = new app();
        ChannelFuture f = a.start(8080);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                a.destroy();
            }
        });

        f.channel().closeFuture().syncUninterruptibly();
    }
}
