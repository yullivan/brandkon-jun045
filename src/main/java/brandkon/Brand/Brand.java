package brandkon.Brand;

import brandkon.Category.Category;
import brandkon.Category.CategoryService;
import brandkon.Product.Product;
import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

//브랜드 목록
@EntityListeners(AuditingEntityListener.class) // 추가
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String imageUrl;
    private String guidelines;

    @CreatedDate
    private LocalDateTime CreatedAt; //createdDateTime

    @LastModifiedDate // 추가
    private LocalDateTime updatedAt = LocalDateTime.now();

    //@ManyToOne
    //private Category category;  //단방향 1:n관계일때 사용

    @OneToMany(mappedBy = "brand")
    private List<BrandCategory> categories;

    protected Brand() {
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Brand(String guidelines) {
        this.guidelines = guidelines;
    }

    public Brand(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    //1카테고리 - n 브랜드
//    @OneToMany(mappedBy = "")    //연관관계의 주인을 정하는 방법은 mappedBy 속성을 지정 ,
//    private List<Brand> brands;  // 주인이 아닌 엔티티 클래스는 mappedBy 속성을 사용해 주인을 정할 수

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
