package pl.littledecothings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.littledecothings.email.EmailSender;
import pl.littledecothings.product.ProductToRentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private ProductToRentService productToRentService;
    private TemplateEngine templateEngine;
    private EmailSender emailSender;

    public HomeController(ProductToRentService productToRentService, TemplateEngine templateEngine, EmailSender emailSender) {
        this.productToRentService = productToRentService;
        this.templateEngine = templateEngine;
        this.emailSender = emailSender;
    }

//    public HomeController(ProductToRentService productToRentService) {
//        this.productToRentService = productToRentService;
//    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
         Context context = new Context();
        context.setVariable("header", "Nowy artykuł na CodeCouple");
        context.setVariable("title", "#8 Spring Boot – email - szablon i wysyłanie");
        context.setVariable("description", "Tutaj jakis opis...");
        String body = templateEngine.process("mail_template", context);
        emailSender.sendEmail("brelok87@gmail.com", "CodeCouple Newsletter", body);
        return "about";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @ModelAttribute("services")
    public List services() {
        List<String> services = new ArrayList<>();
        services.add("zaproszenia");
        services.add("winietki");
        services.add("zawieszki na butelki");
        services.add("podziękowania dla gości");
        services.add("wystrój sali");
        services.add("bukiet");
        services.add("kartki okolicznościowe");
        services.add("inne");

        return services;
    }

}
