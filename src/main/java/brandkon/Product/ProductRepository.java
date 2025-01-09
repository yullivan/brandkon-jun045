package brandkon.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product p ORDER BY p.sales_count DESC LIMIT 5", nativeQuery = true)
    List<Product> findPopular();
}
