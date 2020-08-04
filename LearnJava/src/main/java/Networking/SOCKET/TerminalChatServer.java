package Networking.SOCKET;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TerminalChatServer {

    public static void main(String[] args) throws IOException {

        ServerSocket chatServerListener;
        Socket newClient;

        System.out.println("[Server] Establishing connection...");
        
        chatServerListener = new ServerSocket(9090);
        System.out.println("[Server] Connection established at port: " + chatServerListener.getLocalPort());

        newClient = chatServerListener.accept();
        
        PrintWriter sender = new PrintWriter(newClient.getOutputStream(), true);
        sender.println("Message from Server");
        
        System.out.println("[Server] Message Sent");
        newClient.close();
        chatServerListener.close();

    }

}
