import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;


//ssl加密的websocket
//wss://localhost:8080/ws
public class SecureApp extends app {

    private final SSLContext context;

    public SecureApp(SSLContext context) {
        this.context = context;
    }

    @Override
    protected ChannelInitializer<Channel> createInitializer(ChannelGroup channels) {
        return new SecureServerInitializer(channels, context);
    }

    public static void main(String[] args) {

        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            InputStream ins = new FileInputStream("/home/x/.local/share/mkcert/rootCA.jks");
            ks.load(ins, "123456".toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(ks, "123456".toCharArray());
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
            final SecureApp a = new SecureApp(sslContext);
            ChannelFuture f = a.start(8080);
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    a.destroy();
                }
            });

            f.channel().closeFuture().syncUninterruptibly();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
