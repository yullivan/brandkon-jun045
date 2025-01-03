package brandkon.Category;

import brandkon.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    @Query(value = "SELECT * FROM product p ORDER BY p.sales_count DESC LIMIT 5", nativeQuery = true)
    List<Product> findPopular();
}
