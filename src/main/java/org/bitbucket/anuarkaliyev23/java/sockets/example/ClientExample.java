package org.bitbucket.anuarkaliyev23.java.sockets.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample {
    public static void main(String[] args) throws IOException {
        //127.0.0.1 - Own Ip Address
        try (Socket client = new Socket("127.0.0.1", 8080)) {
            //Write something to Server
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Hello From Client!");

            //Read what server said to client
            InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
            Scanner scanner = new Scanner(inputStreamReader);
            System.out.println("Server says: " + scanner.nextLine());
        }
        try (Socket client = new Socket("127.0.0.1", 8081)) {
            //Write something to Server
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Hello From Client!");

            //Read what server said to client
            InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
            Scanner scanner = new Scanner(inputStreamReader);
            System.out.println("Time Server says: " + scanner.nextLine());
        }
        try (Socket client = new Socket("127.0.0.1", 8082)) {
            //Write something to Server
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Hello From Client!");

            //Read what server said to client
            InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
            Scanner scanner = new Scanner(inputStreamReader);
            System.out.println("Echo Server says: " + scanner.nextLine());
        }
    }
}
