import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String... args){
        String host = "localhost";
        int port = Integer.valueOf(17);
        String message = null;

        if(args.length > 2) {
            message = args[2];
        }

        try {
            Socket sock = new Socket(host, port);
            OutputStream out = sock.getOutputStream();
            PrintWriter output = new PrintWriter(out, true);
            InputStream in = sock.getInputStream();


            if (message != null) {
                output.println(message);
            }

            int readChar = 0;


            while ((readChar = in.read()) != -1) {
                System.out.write(readChar);
                System.out.flush();
            }
            sock.close();
            in.close();
            System.out.close();
            output.close();

        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}