package brandkon.Brand;

import brandkon.Category.Category;
import brandkon.Category.CategoryService;
import brandkon.Product.Product;
import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;

import java.util.List;

//브랜드 목록
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String imageUrl;
    private String guidelines;


    public Brand(String guidelines) {
        this.guidelines = guidelines;
    }

    public Brand(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    //1카테고리 - n 브랜드
//    @OneToMany(mappedBy = "Category")  //연관관계의 주인을 정하는 방법은 mappedBy 속성을 지정 ,
//                                        // 주인이 아닌 엔티티 클래스는 mappedBy 속성을 사용해 주인을 정할 수
//    private List<Brand> brands;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private Category category;

    protected Brand() {
    }

    //getter
    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGuidelines() {
        return guidelines;
    }


    //setter
    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
