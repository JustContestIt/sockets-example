package org.bitbucket.anuarkaliyev23.java.sockets.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8082)) {
            while (true) {
                //Wait for client
                try (Socket client = serverSocket.accept()) {
                    System.out.println("Hey, We got a client!");
                    //Read what client says
                    InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
                    Scanner scanner = new Scanner(inputStreamReader);
                    String clientSay = scanner.nextLine();
                    System.out.println("Client says: " + clientSay);

                    //Write something to client
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    System.out.println("Echo server send same text in Upper Case.");
                    writer.println(clientSay.toUpperCase());
                }
            }
        }
    }
}
