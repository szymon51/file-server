import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;


public class FileClient {
    public static void main(String[] args) {

        String address = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(address, port)) {

            BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream in = new BufferedInputStream(socket.getInputStream());

            // Reading text data
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = reader.readLine();
            System.out.println(line);
          
            socket.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        
    }
}
