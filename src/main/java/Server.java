import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {
    private static int portNumber = 30000;
    private static int numberOfClients = 0;
    public static boolean signalToOpenNewPort = true;
    private static List<SocketChannel> clientSockets = new ArrayList<>();
    private static ByteBuffer buffer = ByteBuffer.allocate(128);

    public Server(){
        System.out.println("Server started");
        while (numberOfClients < 5){
                newClient(portNumber, buffer, clientSockets);
                numberOfClients++;
                portNumber++;
                signalToOpenNewPort = false;

        }
    }


    private static void newClient(int port, ByteBuffer buffer, List<SocketChannel> clientSockets) {

        Runnable task1 = () -> {
            String clientName;
            try {
                ServerSocketChannel channel = ServerSocketChannel.open();
                channel.bind(new InetSocketAddress(port));
                SocketChannel socket = channel.accept();
                System.out.println("somebody connected");
                clientSockets.add(socket);

                int bytes = socket.read(buffer);
                clientName = new String(buffer.array(), 0, bytes);
                buffer.put(" joined...".getBytes());
                messageProcessor(socket, clientSockets, buffer);

                while (true) {
                    bytes = socket.read(buffer);

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
                                         ByteBuffer buffer) {
        for (SocketChannel socket : clientSockets) {
            if (socket != activeSocket) {
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

    private static void joinMessage(String clientName, ByteBuffer buffer, int bytes) {
        String message = new String(buffer.array(), 0, bytes);
        buffer.clear();
        buffer.put(clientName.getBytes());
        buffer.put((": ").getBytes());
        buffer.put(message.getBytes());
    }

}
