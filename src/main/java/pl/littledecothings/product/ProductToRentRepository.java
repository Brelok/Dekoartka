package pl.littledecothings.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductToRentRepository extends JpaRepository <ProductToRent, Long> {
}
