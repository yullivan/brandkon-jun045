package brandkon.Brand;

import brandkon.Product.ProductResponse;

import java.util.List;

public record BrandDetailResponse(Long id,
                                  String name,
                                  String imageUrl
                                  ) {
}
