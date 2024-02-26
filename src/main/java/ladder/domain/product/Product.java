package ladder.domain.product;

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
}
