import java.util.*;

public class Main {
    public static void main(String[] args) {
      try (Scanner sc = new Scanner(System.in)) {
        String strategy = sc.nextLine();
        
        EmailStrategy provider = EmailFactory.create(strategy);
        
        if (provider != null) {
            System.out.println(provider.sendMail());
        } else {
            System.out.println("Invalid email strategy!");
        }
      }
  }
}


interface EmailStrategy {
  public String sendMail();
}

class SMTPEmailStrategy implements EmailStrategy {
  public String sendMail() {
    return "Email sent successfully! SMTP";
  }
}

class SESEmailStrategy implements EmailStrategy {
  public String sendMail() {
    return "Email sent successfully! SES";
  }
}

class EmailFactory {
    static public EmailStrategy create(String strategy) {
        switch (strategy) {
          case "SMTP": return new SMTPEmailStrategy();
          case "SES": return new SESEmailStrategy();
          default: return null;
        }
    }
}
