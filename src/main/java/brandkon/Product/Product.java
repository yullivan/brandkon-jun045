package brandkon.Product;

import brandkon.Brand.Brand;
import jakarta.persistence.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    //현재 만드는 클래스 기준 : 연결하고싶은 클래스
    @ManyToOne
    private Brand brand;

    private String productName;
    private int price;
    private String imageUrl;
    private int expirationDays;
    private int salesCount;

    protected Product() {
    }

    public Product(Brand brand, String productName, int price, String imageUrl, int expirationDays, int salesCount) {
        this.brand = brand;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.expirationDays = expirationDays;
        this.salesCount = salesCount;
    }

    //getter

    public Long getId() {
        return Id;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    public int getSalesCount() {
        return salesCount;
    }

    //setter

    public void setId(Long id) {
        Id = id;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setExpirationDays(int expirationDays) {
        this.expirationDays = expirationDays;
    }

    public void setSalesCount(int salseCount) {
        this.salesCount = salesCount;
    }
}
