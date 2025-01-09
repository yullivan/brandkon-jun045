package brandkon.Brand;

import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {

    BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public List<BrandResponse> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/brands/{brandId}")
    public BrandDetailResponse findOne(@PathVariable Long id){
        return brandService.findDetail(id);
    }
}
