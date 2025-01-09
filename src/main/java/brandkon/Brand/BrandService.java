package brandkon.Brand;

import brandkon.Product.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
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
}
