package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        String host = "Localhost";
        int port = 5000;

        try {
            Socket socket = new Socket(host, port);
            System.out.println("Server'a baglandi!");
            System.out.println("mesaj yazmaya basla (cikmak icin 'exit' yaz)\n");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread okuyucu = new Thread(() -> {
                try {
                    String gelenMesaj;
                    while ((gelenMesaj = reader.readLine()) != null) {
                        System.out.println("Server: " + gelenMesaj);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            okuyucu.start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Ben: ");
                String mesaj = scanner.nextLine();
                writer.println(mesaj);

                if (mesaj.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
