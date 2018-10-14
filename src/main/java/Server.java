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
        List<SocketChannel> listOfUsersSockets = new ArrayList<>();
        ByteBuffer buffer = ByteBuffer.allocate(128);


        Runnable task1 = () -> {
            try {
                ServerSocketChannel channel = ServerSocketChannel.open();
                channel.bind(new InetSocketAddress(30000));
                SocketChannel socket = channel.accept();


                int bytes = socket.read(buffer);
                System.out.println(new String(buffer.array(), 0, bytes) + " joined...");
                buffer.clear();
                while (true){

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(task1);
        if (!es1.isTerminated()) {
            es1.awaitTermination(1, TimeUnit.SECONDS);
        }
        es1.shutdown();


            try {
                ServerSocketChannel channel = ServerSocketChannel.open();
                channel.bind(new InetSocketAddress(20000));
                SocketChannel socket = channel.accept();

                listOfUsersSockets.add(socket);

                int bytes = socket.read(buffer);
                System.out.println(new String(buffer.array(), 0, bytes) + " joined...");
                buffer.clear();


            } catch (IOException e) {
                e.printStackTrace();
            }



        readMessage(listOfUsersSockets, buffer);
    }

    public static void readMessage(List<SocketChannel> listOfUsersSockets, ByteBuffer buffer) {
        while (true) {
            try {
//                listOfUsersSockets.get(0).read(buffer);
                for (SocketChannel socket : listOfUsersSockets) {

                    socket.read(buffer);
                }
                buffer.flip();
//                for (SocketChannel socket : listOfUsersSockets) {
//                    socket.write(buffer);
//                }
                listOfUsersSockets.get(1).write(buffer);
                buffer.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendMessage() {

    }
}
