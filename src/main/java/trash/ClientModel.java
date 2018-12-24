package trash;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientModel extends NewClientController{
    private static int portNumber = 30000;

    private int port;
    private String name;

    private static String m;

    private ByteBuffer buffer;
    private SocketChannel channel;

    public ClientModel(String name) {
        if (portNumber < 30025) {
            this.port = portNumber++;
            this.name = name;

            initializeClient();
        }
    }

    public void initializeClient() {
        buffer = ByteBuffer.allocate(128);



        buffer.put(name.getBytes());
        buffer.flip();

        try {
            channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", port));
            channel.write(buffer);
            buffer.clear();

//            write(channel, buffer);

            read(channel, buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void write(String message) {
        Runnable task = () -> {
            while (true) {
                try {

                    buffer.put(message.getBytes());
                    buffer.flip();
                    channel.write(buffer);
                    buffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(task);
    }

    public void read(SocketChannel channel, ByteBuffer buffer) {
        Runnable task = () -> {
            while (true) {
                int bytes = 0;
                try {
                    bytes = channel.read(buffer);
                    buffer.flip();

                    super.setObservableList(new String(buffer.array(), 0, bytes));

                    buffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(task);

    }
}
