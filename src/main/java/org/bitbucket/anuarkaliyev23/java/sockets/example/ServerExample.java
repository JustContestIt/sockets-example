package org.bitbucket.anuarkaliyev23.java.sockets.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class ServerExample {
    public static void main(String[] args) throws IOException {
        //Open port
        try(ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                //Wait for client
                try (Socket client = serverSocket.accept()) {
                    System.out.println("Hey, We got a client!");
                    //Read what client says
                    InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
                    Scanner scanner = new Scanner(inputStreamReader);
                    System.out.println("Client says: " + scanner.nextLine());

                    //Write something to client
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println("Hello, from server. Time now is " + ZonedDateTime.now());
                }
            }
        }
    }
}
