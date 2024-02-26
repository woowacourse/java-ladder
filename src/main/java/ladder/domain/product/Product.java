package ladder.domain.product;

public class Product {

    private final String name;

    public Product(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("상품 이름은 5글자를 넘을 수 없습니다.");
        }
    }
}
