package server;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String kullaniciAdi;

    public ClientHandler(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            String ilkMesaj = reader.readLine();
            if (ilkMesaj != null && ilkMesaj.startsWith("KULLANICI: ")) {
                kullaniciAdi = ilkMesaj.substring(10);

            } else {
                kullaniciAdi = "Anonim";
            }

            SimpleServer.tumClientlar.add(writer);
            System.out.println(kullaniciAdi + " baglandi!");
            broadcast(kullaniciAdi + " sohbete katildi!");

            String mesaj;
            while ((mesaj = reader.readLine()) != null) {
                if (mesaj.equalsIgnoreCase("exit")) {
                    System.out.println(kullaniciAdi + " ayrildi.");
                    break;
                }
                System.out.println(kullaniciAdi + ": " + mesaj);
                broadcast(kullaniciAdi + ": " + mesaj);

            }

            SimpleServer.tumClientlar.remove(writer);

            reader.close();
            writer.close();
            socket.close();

        } catch (IOException e) {
            System.out.println(kullaniciAdi + " baglantisi koptu.");
            SimpleServer.tumClientlar.remove(writer);
        }
    }

    private void broadcast(String mesaj) {
        for (PrintWriter pw : SimpleServer.tumClientlar) {
            pw.println(mesaj);
        }
    }
}
