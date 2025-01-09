package brandkon.Product;

import java.util.List;

public record ProductDetailResponse(
                                    Long productId,
                                    String productName,
                                    int price,
                                    Brand brand,
                                    int expirationDays // product 엔티티에도 추가해줘야함
)
{
    public record Brand(Long id,
                        String name,
                        String guidelines //브랜드 엔티티에도 추가해줘야함
    ) {

    }
}
