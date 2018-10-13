
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));
            ByteBuffer buffer = ByteBuffer.allocate(128);

            int bytes = channel.read(buffer);
            buffer.flip();
            System.out.println("SM: " + new String(buffer.array(), 0, bytes));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
