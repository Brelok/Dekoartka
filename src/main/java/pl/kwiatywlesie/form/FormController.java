package pl.kwiatywlesie.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.kwiatywlesie.email.EmailSender;
import pl.kwiatywlesie.email.EmailService;

@Controller
public class FormController {

    private FormService formService;
    private EmailService emailService;
    private final TemplateEngine templateEngine;
    private final EmailSender emailSender;

    public FormController(FormService formService, EmailService emailService, TemplateEngine templateEngine, EmailSender emailSender) {
        this.formService = formService;
        this.emailService = emailService;
        this.templateEngine = templateEngine;
        this.emailSender = emailSender;
    }

    @PostMapping("/form")
    public String form(@RequestParam String name,
                       @RequestParam String surname,
                       @RequestParam String phoneNumber,
                       @RequestParam String email,
                       @RequestParam String subject,
                       @RequestParam String date,
                       @RequestParam String message
    ) {

        Form form = new Form(name, surname, phoneNumber, email, subject, date, message);
        formService.add(form);
        Context context = emailService.setFormToEmail(name, surname, phoneNumber, email, subject, date, message);
        String body = templateEngine.process("mail_template", context);
        emailSender.sendEmail("kwiatywlesie@kwiatywlesie.pl", subject, body);
        return "thankyou";
    }


}
