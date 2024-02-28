package ladder.domain;

public class Price {
    private final String price;

    public Price(String price) {
        validate(price);

        this.price = price;
    }

    private void validate(String priceName) {
        validateNotEmpty(priceName);
        validateMaxLength(priceName);
    }

    private void validateNotEmpty(String priceName) {
        if (priceName == null || priceName.isBlank()) {
            throw new IllegalArgumentException("상품 이름은 한글자 이상이어야 합니다.");
        }
    }

    private void validateMaxLength(String priceName) {
        if (priceName.length() > 5) {
            throw new IllegalArgumentException("상품 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    public String getPrice() {
        return price;
    }
}
