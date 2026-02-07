# Chat Application

Basit bir Java Socket tabanlı chat uygulaması. JavaFX ile arayüz, Socket programlama ile mesajlaşma altyapısı yaptım.

## Ne Yapıyor?

Birden fazla kullanıcı aynı anda sohbet edebiliyor. Server tarafı mesajları alıp diğer herkese iletiyor (broadcast). Client tarafında da JavaFX ile basit bir arayüz var.

## Teknolojiler

- Java 17
- JavaFX 21
- Maven
- Socket Programlama

## Proje Yapısı

```
src/
├── main/
│   ├── java/
│   │   ├── client/
│   │   │   ├── ChatClient.java      # Ana uygulama (JavaFX)
│   │   │   ├── ChatController.java  # Arayüz kontrolü
│   │   │   └── SimpleClient.java    
│   │   └── server/
│   │       ├── SimpleServer.java    # Server başlatma
│   │       └── ClientHandler.java   # Her client için ayrı thread
│   └── resources/
│       └── client/
│           └── chat.fxml            # Arayüz tasarımı
```

## Gereksinimler

- Java 17+

## Nasıl Çalıştırılır?

### JAR Dosyaları ile (Önerilen)

Releases kısmından JAR dosyalarını indirin veya kendiniz build edin:

```bash
# Server'ı başlat
java -jar ChatServer.jar

# Yeni bir terminal aç ve Client'ı başlat
java -jar ChatClient.jar
```

### Kaynak Koddan

Maven kurulu olmalı:

```bash
# JAR oluştur
mvn clean package

# JAR dosyaları target/ klasörüne oluşur
```

Uygulama açılınca kullanıcı adınızı girip bağlanabilirsiniz.

## Özellikler

- Çoklu kullanıcı desteği (her client ayrı thread)
- Gerçek zamanlı mesajlaşma
- Kullanıcı ismi ile giriş
- Basit ve kullanışlı arayüz

## Ekran Görüntüleri

![Uygulama Ekran Görüntüleri](screenshots/app-screenshots.jpg)

*Sol: Giriş ekranı - Kullanıcı adı girişi | Sağ: Sohbet ekranı - Çoklu kullanıcı sohbeti*

## Notlar

- Server'ı önce başlatmanız lazım yoksa client bağlanamaz
- Şimdilik sadece localhost'ta çalışıyor
- Exit yazarak çıkış yapabilirsiniz

---

Yazılım Mühendisliği dersi için yaptığım proje.
