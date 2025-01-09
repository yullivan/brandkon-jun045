package brandkon.Product;

public record CreateProductRequest(String brandname,
                                   String productName,
                                   int price,
                                   String imageUrl) {
}
