package brandkon.Brand;

import brandkon.Product.Product;
import brandkon.Product.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    BrandRepository brandRepository;
    BrandCategoryRepository brandCategoryRepository;

    public BrandService(BrandRepository brandRepository, BrandCategoryRepository brandCategoryRepository) {
        this.brandRepository = brandRepository;
        this.brandCategoryRepository = brandCategoryRepository;
    }

    //브랜드 전체 목록  조회
    public List<BrandResponse> findAll(){
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> new BrandResponse(
                        brand.getId(),
                        brand.getName(),
                        brand.getImageUrl()))
                .toList();
    }

    //브랜드 상세 목록 조회
    public BrandDetailResponse findDetail(Long id){
        Brand brand = brandRepository.findById(id).orElseThrow();

        return new BrandDetailResponse(
                brand.getId(),
                brand.getName(),
                brand.getImageUrl());
    }

    //브랜드 전체 중 인기상품 5개



    //다대다 관계
    //BrandCategory는 Brand와 Category의 관계를 연결하는 엔티티이므로,
    // Brand를 가져오기 위해서는 BrandCategory를 통해 Brand 객체에 접근
    public List<BrandResponse> findOne(String slug){
        List<BrandCategory> brands = brandCategoryRepository.findByCategorySlug(slug);
        return brands.stream()
                .map( brand -> new BrandResponse(
                        brand.getBrand().getId(),
                        brand.getBrand().getName(),
                        brand.getBrand().getImageUrl()))
                .toList();
    }






}
