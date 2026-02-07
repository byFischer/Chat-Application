package client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.net.*;

public class ChatController {

    @FXML
    private TextArea mesajAlani;

    @FXML
    private TextField mesajInput;

    @FXML
    private Button gonderBtn;

    private PrintWriter writer;
    private BufferedReader reader;
    private String kullaniciAdi;

    @FXML
    private void initialize() {
        kullaniciAdi = ChatClient.getKullaniciAdi();
        serverBaglan();
    }

    private void serverBaglan() {
        try {
            Socket socket = new Socket("localhost", 5000);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            mesajAlani.appendText("Server'a baglandin!\n\n");

            writer.println("KULLANICI: " + kullaniciAdi);

            Thread okuyucu = new Thread(() -> {
                try {
                    String gelenMesaj;
                    while ((gelenMesaj = reader.readLine()) != null) {
                        String mesaj = gelenMesaj;
                        Platform.runLater(() -> {
                            mesajAlani.appendText(mesaj + "\n");
                        });
                    }
                } catch (IOException e) {
                    Platform.runLater(() -> {
                        mesajAlani.appendText("Baglanti kesildi.\n");
                    });
                }
            });
            okuyucu.start();
        } catch (Exception e) {
            mesajAlani.appendText("Baglanti kurulamadi!\n");

        }

    }

    @FXML
    private void mesajGonder() {
        String mesaj = mesajInput.getText().trim();
        if (!mesaj.isEmpty() && writer != null) {
            writer.println(mesaj);
            mesajInput.clear();
        }
    }
}
