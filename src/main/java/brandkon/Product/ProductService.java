package brandkon.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //상품 전체 목록 조회
    public List<ProductResponse> findAll(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getBrand().getName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl()
                ))
                .toList();
    }


    //상품 상세 조회
    public ProductDetailResponse findDetail(Long id) {
        Product product = productRepository.findById(id).orElseThrow();

        return new ProductDetailResponse(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                new ProductDetailResponse.Brand(
                        product.getBrand().getId(),
                        product.getBrand().getName(),
                        product.getBrand().getGuidelines()),
                product.getExpirationDays()
        );
    }

    //인기 상품 목록 조회
    public List<ProductResponse> findPopular() {
         List<Product> products = productRepository.findPopular();

         return products.stream()
                 .map(product -> new ProductResponse(
                         product.getId(),
                         product.getBrand().getName(),
                         product.getProductName(),
                         product.getPrice(),
                         product.getImageUrl()))
                 .toList();


    }
}
