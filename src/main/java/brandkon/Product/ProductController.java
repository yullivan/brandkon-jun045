package brandkon.Product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }

//    @GetMapping("/products/popular")
//    public List<ProductResponse> find(){
//        return productService.findPopular();
//    }

    //상품 상세 조회
    @GetMapping("/products/{productId}")
    public ProductDetailResponse find(@PathVariable Long Id){
        return productService.findDetail(Id);
    }
}