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
import java.util.concurrent.TimeUnit;

public class Server {

    public static void main(String[] args) throws Exception {
        List<SocketChannel> clientSockets = new ArrayList<>();
        ByteBuffer buffer = ByteBuffer.allocate(128);
        int port1 = 30000;
        int port2 = 20000;
        int port3 = 40000;
        int port4 = 50000;
        newClient(port1, buffer, clientSockets);
        newClient(port2, buffer, clientSockets);
        newClient(port3, buffer, clientSockets);
        newClient(port4, buffer, clientSockets);

    }
    private static void newClient(int port, ByteBuffer buffer, List<SocketChannel> clientSockets){

        Runnable task1 = () -> {
            String clientName;
            try {
                ServerSocketChannel channel = ServerSocketChannel.open();
                channel.bind(new InetSocketAddress(port));
                SocketChannel socket = channel.accept();
                clientSockets.add(socket);

                int bytes = socket.read(buffer);
                clientName = new String(buffer.array(),0, bytes);
                buffer.put((" joined...").getBytes());
                messageProcessor(socket, clientSockets, buffer);

                while (true){
                    bytes = socket.read(buffer);
                    String message = new String(buffer.array(), 0, bytes);
                    buffer.clear();
                    buffer.put(clientName.getBytes());
                    buffer.put((": ").getBytes());
                    buffer.put(message.getBytes());
                    messageProcessor(socket, clientSockets, buffer);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(task1);
        if (!es1.isTerminated()) {
            try {
                es1.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        es1.shutdown();
    }

    private static void messageProcessor(SocketChannel activeSocket, List<SocketChannel> clientSockets,
                                         ByteBuffer buffer){

        for (SocketChannel socket : clientSockets){
            if (socket != activeSocket){
                try {
                    buffer.flip();
                    socket.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        buffer.clear();
    }

}
