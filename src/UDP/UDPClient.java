package UDP;

import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");

        String message = "CLIENT: Hello UDP Server! Making a Ping request to you";
        byte[] buffer = message.getBytes();

        DatagramPacket request = new DatagramPacket(buffer, buffer.length, serverAddress, 5000);
        socket.send(request);

        // Receive response
        byte[] responseBuffer = new byte[1024];
        DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
        socket.receive(response);

        System.out.println("Server Response: " + new String(response.getData(), 0, response.getLength()));
        socket.close();
    }
}