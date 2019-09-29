package Client;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Client {
    private SSLSocket socket = null;

    public Client() throws Exception{
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        socket = (SSLSocket)factory.createSocket("localhost", 8080);
    }

    public void connect() {
        try {
            PrintWriter opt = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );

            opt.println("Hello World!");
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            System.out.println(input.lines());
            opt.close();
            input.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new Client().connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
