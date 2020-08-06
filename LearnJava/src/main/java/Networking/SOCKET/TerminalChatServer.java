package Networking.SOCKET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(newClient.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.print(">> ");
            String serverMsg = keyboard.readLine();

            if(serverMsg.equals("exit")){
                break;
            }

            sender.println(serverMsg);

            String clientMsg = reader.readLine();
            System.out.println(">> "+clientMsg);


        }        

        
        newClient.close();
        chatServerListener.close();

    }

}
