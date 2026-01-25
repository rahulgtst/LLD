import java.util.*;

public class Main {
    public static void main(String[] args) {
      Notification n = NotificationFactory.create("EMAIL");
      n.send();
  }
}

interface Notification {
  void send();
}

class EmailNotification implements Notification {
  @Override
  public void send() {
    System.out.println("Email Notification Sent");
  }
}

class SMSNotification implements Notification {
  @Override
  public void send() {
    System.out.println("SMS Notification Sent");
  }
}

class PushNotification implements Notification {
  @Override
  public void send() {
    System.out.println("Push Notification Sent");
  }
}

class NotificationFactory {
  public static Notification create(String type) {
    switch(type) {
      case "EMAIL":
        return new EmailNotification();
      case "PUSH":
        return new PushNotification();
      case "SMS":
        return new SMSNotification();
      default:
        throw new IllegalArgumentException("Unknown type: " + type);
    }
  }
}
