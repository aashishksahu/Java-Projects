package Networking.SOCKET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter sender = new PrintWriter(clientSocket.getOutputStream(), true);

            while(true){
                System.out.print(">> ");
                String clientMsg = keyboard.readLine();

                if(clientMsg.equals("exit")){
                    break;
                }

                sender.println(clientMsg);

                String serverMsg = receiver.readLine();
                System.out.println(">> "+serverMsg);

            }


        }

        System.out.println("[Client] Socket closed");

    }
}
