import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileClient {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String address = "localhost";
        int cliPort = 8080;
        int filePort = 8081;

        try (Socket socket = new Socket(address, cliPort)) {

            InputStreamReader isr = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);            
            BufferedWriter bw = new BufferedWriter(osw);

            System.out.println(br.readLine());

            System.out.println("\nWelcome to cli interface, available commends are: LIST, GET, PUT, HELP");
            while (true) {
                String request = scanner.nextLine();
                if (request.equals("LIST")){
                    bw.write(request);
                    bw.newLine();
                    bw.flush();
                    System.out.println(br.readLine());
                } else {
                    bw.write(request);
                    bw.newLine();
                    bw.flush();
                }
            }

        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        
    }
}
