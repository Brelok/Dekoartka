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


    public HomeController(ProductToRentService productToRentService) {
        this.productToRentService = productToRentService;
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
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
