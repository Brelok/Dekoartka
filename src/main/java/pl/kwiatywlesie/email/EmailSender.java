package pl.kwiatywlesie.email;

public interface EmailSender {

    void sendEmail (String to, String subject, String content);
}
