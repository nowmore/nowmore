package Server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(port)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(
                                    new ServeHandler()
                            );
                        }
                    });

            ChannelFuture future = bootstrap.bind().sync();
            System.out.println(Server.class.getName() + " started and listen on "
            + future.channel().localAddress());

            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) {
        try {
            new Server(6666).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
