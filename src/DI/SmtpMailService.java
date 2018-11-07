package DI;

public class SmtpMailService implements MailService {
    @Override
    public void sendMessage(String messageHelloWorld) {
        System.out.println("SmtpMailService sendMessage");
    }
}
