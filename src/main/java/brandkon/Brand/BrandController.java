package brandkon.Brand;

import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public List<BrandResponse> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/brands/{brandId}")
    public BrandDetailResponse findById(@PathVariable Long productId){
        return brandService.findDetail(productId);
    }
}
