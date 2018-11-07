package DI;

import DI.with.RegisterFormController;

public class Framework {
    public static void main(String[] args) {

        MailService smtpMailService = new SmtpMailService();
        MailService imapMailService = new ImapMailService();

        RegisterFormController controller = new RegisterFormController();

        controller.setMailService(smtpMailService);
        controller.send();
    }
}
