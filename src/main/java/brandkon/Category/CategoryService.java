package brandkon.Category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //메인에서 보이는 카테고리 목록 ( 추천, 종류 보여줌)
    //전체 브랜드중 추천 5개

//    //각 카테고리 생성
//    public void create(CreateCategoryRequest request) {
//        Category category = categoryRepository.findByName(request.name()).orElseThrow();
//        categoryRepository.save(new Category(
//                request.name(),
//                request.slug(),
//                request.imageUrl()));
//    }

    // 카테고리 목록 조회
    public List<CategoryResponse> findAll(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map( category -> new CategoryResponse(
                        category.getId(),
                        category.getName(),
                        category.getSlug(),
                        category.getImageUrl()))
                .toList();
    }

//    //수정
//    @Transactional
//    public Category update(Long id, CreateCategoryRequest request){
//        Category 수정할카테고리 = categoryRepository.findById(id).orElseThrow();
//        수정할카테고리.setName(request.name());
//
//        return 수정할카테고리;
//    }
//
//    //삭제
//    public void delete(Long id){
//        Category 삭제할카테고리 = categoryRepository.findById(id).orElseThrow();
//        categoryRepository.deleteById(id);
//    }



}
