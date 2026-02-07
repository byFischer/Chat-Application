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
- Maven

## Nasıl Çalıştırılır?

### 1. Önce Server'ı Başlat

```bash
# server klasöründeki SimpleServer.java dosyasını çalıştır
# Port: 5000
```

### 2. Client'ı Aç

```bash
mvn clean javafx:run
```

Uygulama açılınca kullanıcı adınızı girip bağlanabilirsiniz.

## Özellikler

- Çoklu kullanıcı desteği (her client ayrı thread)
- Gerçek zamanlı mesajlaşma
- Kullanıcı ismi ile giriş
- Basit ve kullanışlı arayüz

## Ekran Görüntüsü

Uygulama açıldığında kullanıcı adı soruluyor, sonra sohbet ekranı açılıyor and mesaj atabiliyorsunuz.

## Notlar

- Server'ı önce başlatmanız lazım yoksa client bağlanamaz
- Şimdilik sadece localhost'ta çalışıyor
- Exit yazarak çıkış yapabilirsiniz

---

Yazılım Mühendisliği dersi için yaptığım proje.
