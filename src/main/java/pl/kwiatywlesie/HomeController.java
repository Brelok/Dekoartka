package pl.kwiatywlesie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {


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
