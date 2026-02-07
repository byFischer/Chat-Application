package client;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class ChatClient extends Application {
    private static String kullaniciAdi;

    @Override
    public void start(Stage stage) throws Exception {
        String isim = KullaniciAdisor();

        if (isim == null || isim.trim().isEmpty()) {
            System.exit(0);
            return;
        }

        kullaniciAdi = isim.trim();

        Parent root = FXMLLoader.load(getClass().getResource("chat.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Chat Client");
        stage.show();
    }

    private String KullaniciAdisor() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Chat uygulamasi");
        dialog.setHeaderText("Hosgeldiniz!!");

        ButtonType baglanBtn = new ButtonType("Baglan", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(baglanBtn, ButtonType.CANCEL);

        TextField isimInput = new TextField();
        isimInput.setPromptText("kullanici adiniz...");
        VBox content = new VBox(10);
        content.setPadding(new Insets(20));
        content.getChildren().addAll(new Label("Kullanici adinizi girin: "), isimInput);

        dialog.getDialogPane().setContent(content);

        dialog.setResultConverter(Button -> {
            if (Button == baglanBtn) {
                return isimInput.getText();
            }
            return null;
        });

        return dialog.showAndWait().orElse(null);
    }

    public static String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
