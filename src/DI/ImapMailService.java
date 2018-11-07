package DI;

public class ImapMailService implements MailService {

    @Override
    public void sendMessage(String messageHelloWorld) {
        System.out.println("ImapMailService sendMessage");
    }
}
