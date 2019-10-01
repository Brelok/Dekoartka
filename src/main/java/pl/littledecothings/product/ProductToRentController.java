package pl.littledecothings.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductToRentController {

    private ProductToRentService productToRentService;

    @Autowired
    public ProductToRentController(ProductToRentService productToRentService) {
        this.productToRentService = productToRentService;
    }


}
