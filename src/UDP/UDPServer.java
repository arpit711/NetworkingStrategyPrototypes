import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];

        System.out.println("UDP Server started...");

        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);

            String receivedMessage = new String(request.getData(), 0, request.getLength());
            System.out.println("Received: " + receivedMessage);

            // Send response
            String response = "Hello from UDP Server!";
            byte[] responseData = response.getBytes();
            DatagramPacket reply = new DatagramPacket(responseData, responseData.length,
                    request.getAddress(), request.getPort());
            socket.send(reply);
        }
    }
}
