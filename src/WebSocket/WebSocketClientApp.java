package WebSocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;

public class WebSocketClientApp {
    public static void main(String[] args) throws Exception {
        WebSocketClient client = new WebSocketClient(new URI("ws://localhost:8080/ws")) {
            @Override
            public void onOpen(ServerHandshake handshake) {
                System.out.println("Connected to WebSocket Server");
                send("Hello Server!");
            }

            @Override
            public void onMessage(String message) {
                System.out.println("Server Response: " + message);
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                System.out.println("Disconnected: " + reason);
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
            }
        };

        client.connect();
        Thread.sleep(5000);  // Keep connection alive for testing
        client.close();
    }
}
