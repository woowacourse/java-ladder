package ladder.domain.product;

import java.util.List;

public class Products {

    private static final int MIN_PRODUCTS = 2;

    private final List<Product> values;

    private Products(List<Product> values) {
        validate(values);
        this.values = values;
    }

    public static Products from(List<String> names) {
        List<Product> values = names.stream()
                .map(Product::new)
                .toList();
        return new Products(values);
    }

    private void validate(List<Product> values) {
        if (values.size() < MIN_PRODUCTS) {
            throw new IllegalArgumentException("상품은 적어도 2개 이상 있어야 합니다.");
        }
    }
}
