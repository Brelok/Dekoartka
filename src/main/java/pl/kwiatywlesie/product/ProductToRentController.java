package pl.kwiatywlesie.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductToRentController {

    private ProductToRentService productToRentService;

    @Autowired
    public ProductToRentController(ProductToRentService productToRentService) {
        this.productToRentService = productToRentService;
    }


}
