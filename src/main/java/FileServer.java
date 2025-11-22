import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	public static void main(String[] args) {

		int port = 8080;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Server listening on localhost:8080");
			while(true) {
				Socket socket = serverSocket.accept();
				BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
				BufferedInputStream in = new BufferedInputStream(socket.getInputStream());

				out.write("hello".getBytes());
				out.flush();
			}
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}
	}
}
