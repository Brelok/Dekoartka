package pl.littledecothings.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    private FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping("/form")
    public String form (@RequestParam String name,
                        @RequestParam String phoneNumber,
                        @RequestParam String email,
                        @RequestParam String subject,
                        @RequestParam String message){

        Form form = new Form(name, phoneNumber, email, subject, message);
        formService.add(form);
        return "redirect:/contact";
    }
}
