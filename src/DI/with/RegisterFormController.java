package DI.with;

import DI.MailService;
import DI.MailServiceSendMessageException;

public class RegisterFormController {
    private static final String
            MESSAGE_HELLO_WORLD = "Hello, World!";

    private MailService mailService;

    public void send() {

        try {
            mailService.sendMessage(MESSAGE_HELLO_WORLD);
        } catch (MailServiceSendMessageException e) {
            e.printStackTrace();
        }// try/catch
    }// send()

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }
}
