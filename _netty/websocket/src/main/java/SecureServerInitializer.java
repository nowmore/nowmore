import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

public class SecureServerInitializer extends ServerInitializer {
    private final SSLContext context;

    public SecureServerInitializer(ChannelGroup channels, SSLContext context) {
        super(channels);
        this.context = context;
    }

    @Override
    public void initChannel(Channel ch) throws Exception {
        super.initChannel(ch);

        SSLEngine e = context.createSSLEngine();
        e.setUseClientMode(false);
        e.setNeedClientAuth(false);
        e.setWantClientAuth(false);
        ch.pipeline().addFirst(new SslHandler(e));
    }
}
