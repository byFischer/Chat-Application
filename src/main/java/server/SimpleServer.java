package server;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.security.sasl.SaslServer;

public class SimpleServer {
    public static List<PrintWriter> tumClientlar = new ArrayList<>();

    public static void main(String[] args) {

        int port = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("server baslatildi port: " + port);
            System.out.println("clientlar bekleniyor... ");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(clientSocket);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
