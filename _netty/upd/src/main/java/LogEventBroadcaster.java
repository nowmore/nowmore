import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;

public class LogEventBroadcaster {
    private final Bootstrap bootstrap;
    private final File file;
    private final EventLoopGroup group;

    public LogEventBroadcaster(InetSocketAddress address, File file) {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();

        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new LogEventEncoder(address));

        this.file = file;
    }

    public void run() throws Exception {
        Channel ch = bootstrap.bind(0).syncUninterruptibly().channel();

        System.out.println("LogEventBroadcaster running");

        long pointer = 0;

        for(;;) {
            long len = file.length();

            if(len < pointer) {
                pointer = len;
            } else if (pointer < len){
                RandomAccessFile raf = new RandomAccessFile(file, "r");
                raf.seek(pointer);
                String line;

                while((line = raf.readLine()) != null) {
                    ch.writeAndFlush(new LogEvent(null, file.getAbsolutePath(), line, -1));
                }
                pointer = raf.getFilePointer();
                raf.close();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.interrupted();
                break;
            }
        }
    }

    public void stop() {
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        LogEventBroadcaster broadcaster = new LogEventBroadcaster(new InetSocketAddress("255.255.255.255", 6666),
                new File("/var/log/pacman.log"));

        try {
            broadcaster.run();
        } finally {
            broadcaster.stop();
        }
    }
}
