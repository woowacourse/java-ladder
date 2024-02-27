package ladder.domain.product;

import java.util.Objects;

public class Product {

    private static final int MIN_NAME_LENGTH = 5;

    private final String name;

    public Product(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateIsNotEmpty(name);
        validateLengthIsInRange(name);
    }

    private void validateIsNotEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("상품 이름은 적어도 1글자 이상이어야 합니다.");
        }
    }

    private void validateLengthIsInRange(String name) {
        if (name.length() > MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("상품 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Product product = (Product) object;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        if (name == null) {
            return 0;
        }
        return name.hashCode();
    }
}
