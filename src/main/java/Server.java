import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        List<ServerSocketChannel> listOfClients = new ArrayList<>();
        ByteBuffer buffer = ByteBuffer.allocate(128);

        Runnable task = () -> {
            for (int i = 0; i < 25; i++) {
                try {
                    ServerSocketChannel channel = ServerSocketChannel.open();
                    channel.bind(new InetSocketAddress(30000));
                    listOfClients.add(channel);
                    SocketChannel socket = channel.accept();
                    int bytes = socket.read(buffer);
                    System.out.println(new String(buffer.array(), 0, bytes) + " joined...");
                    buffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(task);

        while (true) {

        }


    }
}
