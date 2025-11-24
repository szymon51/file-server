import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;

public class FileServer {
	public static void main(String[] args) {
		new FileServer().start();
	}

	public void start() {
		int cliPort = 8080;
		int filePort = 8081;
		try (ServerSocket serverSocket = new ServerSocket(cliPort)) {

			System.out.println("Server listening on localhost: " + cliPort);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Client connected: " + socket.getInetAddress());

				InputStreamReader isr = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
				OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);

				bw.write("Hello client");
				bw.newLine();
				bw.flush();
				while (true) {
					String response = br.readLine();
					if (response.equals("LIST")) {
						bw.write("requested LIST command");
						bw.newLine();
						bw.flush();
					} else {
						System.out.println(response);
					}
				}

			}
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}
	}
}
