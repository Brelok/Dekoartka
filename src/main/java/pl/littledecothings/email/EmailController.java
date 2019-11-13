package pl.littledecothings.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.Template;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Controller
public class EmailController {

    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @GetMapping("/form")
    public String sendEmail() {
        Context context = new Context();
        context.setVariable("header", "Nowy artykuł na CodeCouple");
        context.setVariable("title", "#8 Spring Boot – email - szablon i wysyłanie");
        context.setVariable("description", "Tutaj jakis opis...");
        String body = templateEngine.process("mail_template", context);
        emailSender.sendEmail("brelok87@gmail.com", "CodeCouple Newsletter", body);
        return "index";
    }
}
