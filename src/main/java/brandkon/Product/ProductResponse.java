package brandkon.Product;

public record ProductResponse(
        Long Id,
        String brandName,
        String productName,
        int price,
        String imageUrl
) {
}
