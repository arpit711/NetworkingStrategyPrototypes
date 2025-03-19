import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server started. Waiting for client...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String receivedMessage = input.readLine();
            System.out.println("Received: " + receivedMessage);

            output.println("Hello from Server!");

            socket.close();

        }
    }
}
