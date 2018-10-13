
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client1 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(128);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your nick name: ");
        String name = sc.nextLine();
        buffer.put(name.getBytes());

        final SocketChannel channel;
        try {
            channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));
            channel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Runnable task = () -> {
            while (true){
                String message = sc.nextLine();
                buffer.put(message.getBytes());
                buffer.flip();
                channel.write(buffer);

            }
        };

        while (true)
        String message = sc.nextLine();
        buffer.put(message.getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer.clear();

        channel.read(buffer);
        buffer.flip();
        System.out.println("SM: " + new String(buffer.array(), 0, buffer.array().length));


    }
}
