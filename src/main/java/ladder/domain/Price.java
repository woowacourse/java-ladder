package ladder.domain;

public class Price {
    private static final int MAX_LENGTH = 5;
    private final String price;

    public Price(String price) {
        validate(price);

        this.price = price;
    }

    private void validate(String priceName) {
        validateMaxLength(priceName);
    }

    private void validateMaxLength(String priceName) {
        if (priceName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("상품 이름은 " + MAX_LENGTH + "글자를 넘을 수 없습니다.");
        }
    }

    public String getPrice() {
        return price;
    }
}
