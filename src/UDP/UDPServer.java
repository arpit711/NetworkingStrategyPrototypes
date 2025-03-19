package UDP;

import java.net.*;
/*
*
* The command names all the active Ports in use in the local maching at the moment
* Command: lsof -i :5000
*
* */
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
            String response = "Hello from UDP Server! The Final Response Sent from Server after receiving request: " + receivedMessage;
            byte[] responseData = response.getBytes();
            DatagramPacket reply = new DatagramPacket(responseData, responseData.length,
                    request.getAddress(), request.getPort());
            socket.send(reply);
        }
    }
}
