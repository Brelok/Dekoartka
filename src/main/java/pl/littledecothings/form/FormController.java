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
        return "redirect:/contact";
    }


}
