package Networking.SOCKET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TerminalChatClient {

    public static void main(String[] args) throws IOException {

        String serverIP = "127.0.0.1";
        int serverPort = 9090;

        // Setting up receiver and sender
        try ( Socket clientSocket = new Socket(serverIP, serverPort)) {
            System.out.println("[Client] Server Detected");
            System.out.println("[Client] Connection Established");
            // Setting up receiver and sender
            BufferedReader receiver = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println(receiver.readLine());
        }

        System.out.println("[Client] Socket closed");

    }
}
