package pl.littledecothings.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailSender {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;

    }

    @Override
    public void sendEmail(String to, String subject, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom("kontakt@kwiatywlesie.pl");
            helper.setSubject(subject);
            helper.setText(content, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }

    public Context setFormToEmail(String name, String surname, String phoneNumber, String email, String subject, String date, String message) {

            String phoneNumberTrim = phoneNumber.trim();
            String partOne = phoneNumberTrim.substring(0, 3);
            String partTwo = phoneNumberTrim.substring(3, 6);
            String partThree = phoneNumberTrim.substring(6, 9);
            String newPhoneNumber = partOne + "-" + partTwo + "-" + partThree;


        Context context = new Context();
        context.setVariable("header", "Nowa wiadomość z formularza");
        context.setVariable("title", subject);
        context.setVariable("message", "Wiadomość: " + message);
        context.setVariable("date", "Data: " + date);
        context.setVariable("name", "Imię: " + name);
        context.setVariable("surname", "Nazwisko: " + surname);
        context.setVariable("email", "Email: " + email);
        context.setVariable("phoneNumber", "Nr telefonu: " + newPhoneNumber);
        return context;

    }
}
