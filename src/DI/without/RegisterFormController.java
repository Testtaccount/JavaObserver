package DI.without;

import DI.MailService;
import DI.MailServiceSendMessageException;
import DI.SmtpMailService;

public class RegisterFormController {
    private static final String MESSAGE_HELLO_WORLD = "Hello, World!";

    public void send() {

        MailService mailService = new SmtpMailService();

        try {
            mailService.sendMessage(MESSAGE_HELLO_WORLD);
        } catch (MailServiceSendMessageException e) {
            e.printStackTrace();
        }// try/catch
    }// send()
}
