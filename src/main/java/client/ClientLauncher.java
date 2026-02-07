package client;

/**
 * JavaFX uygulamasini JAR'dan calistirmak icin wrapper sinif.
 * JavaFX'in modul sistemi yuzunden Application sinifini direkt calistirmak
 * sorunlu,
 * bu yuzden bu launcher sinifini kullaniyoruz.
 */
public class ClientLauncher {
    public static void main(String[] args) {
        ChatClient.main(args);
    }
}
