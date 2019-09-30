package pl.littledecothings.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductToRentService {

    private ProductToRentRepository productToRentRepository;

    @Autowired
    public ProductToRentService(ProductToRentRepository productToRentRepository) {
        this.productToRentRepository = productToRentRepository;
    }
}
