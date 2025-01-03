package brandkon.Brand;

import brandkon.Category.Category;
import jakarta.persistence.*;

@Entity
public class BrandCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    //이미 브랜드와 카테고리에서 사용하는 필드는 중복할 필요없음

    //다대다 - 한 브랜드가 여러 카테고리에 들어감
    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;

    public BrandCategory() {
    }

    public BrandCategory(Brand brand, Category category) {
        this.brand = brand;
        this.category = category;
    }

    //getter


    public Long getId() {
        return Id;
    }

    public Brand getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }

    //setter
    public void setId(Long id) {
        Id = id;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
