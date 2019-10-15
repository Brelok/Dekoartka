package pl.littledecothings.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class FormController {

    private FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/form")
    public String form(@RequestParam String name,
                       @RequestParam String phoneNumber,
                       @RequestParam String email,
                       @RequestParam String subject,
                       @RequestParam String date,
                       @RequestParam String message,
                       @RequestParam String[] services) {

        Form form = new Form(name, phoneNumber, email, subject, date, message, services);
        formService.add(form);
        return "redirect:/contact";
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
