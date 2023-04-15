import java.io.*;
import java.net.*;
public class UDPClient {


    public static void main(String[] args) {
        String hostname = "localhost";
        //int port = Integer.parseInt(args[1]);
        //String hostname = args[0];

        //source: https://www.codejava.net/java-se/networking/java-udp-client-server-program-example

        int port = 17;
        DatagramSocket socket = null;

        try {
            InetAddress address = InetAddress.getByName(hostname);
            socket = new DatagramSocket();
            DatagramPacket request = new DatagramPacket(new byte[512], 512, address, port);
            socket.send(request);

            byte[] buffer = new byte[512];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);

            socket.receive(response);

            String quote = new String(buffer, 0, response.getLength());

            System.out.println(quote);
            System.out.println();
            socket.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}