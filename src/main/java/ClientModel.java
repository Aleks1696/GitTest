import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientModel {
    private static int portNumber = 30000;

    private int port;

    public ClientModel() {
        if (portNumber < 30025) {
            this.port = portNumber++;

            Server.setSignalForCreatingNewClient(true);

            initializeClient();
        }
    }

    public void initializeClient() {
        ByteBuffer buffer = ByteBuffer.allocate(128);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your nick name: ");
        String name = sc.nextLine();
        buffer.put(name.getBytes());
        buffer.flip();

        SocketChannel channel;
        try {
            channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", port));
            channel.write(buffer);
            buffer.clear();

            write(channel, buffer, sc);

            read(channel, buffer, sc);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void write(SocketChannel channel, ByteBuffer buffer, Scanner sc) {
        Runnable task = () -> {
            while (true) {
                try {
                    String message = sc.nextLine();
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

    public void read(SocketChannel channel, ByteBuffer buffer, Scanner sc) {
        while (true) {
            int bytes = 0;
            try {
                bytes = channel.read(buffer);
                buffer.flip();
                System.out.println(new String(buffer.array(), 0, bytes));
                buffer.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
