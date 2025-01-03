package brandkon.Category;

public record CreateCategoryRequest(
        String name,
        String slug,
        String imageUrl) {
}
