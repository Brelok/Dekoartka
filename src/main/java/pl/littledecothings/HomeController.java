package pl.littledecothings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.littledecothings.product.ProductToRentService;

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

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
