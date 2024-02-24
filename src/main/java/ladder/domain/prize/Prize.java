package ladder.domain.prize;

public record Prize(String name) {
    private static final int MAXIMUM_NAME_RANGE = 5;

    public Prize {
        validate(name);
    }

    private void validate(String name) {
        validateNameRange(name);
    }

    private void validateNameRange(String name) {
        if (name.isBlank() || name.length() > MAXIMUM_NAME_RANGE) {
            throw new IllegalArgumentException(String.format("상품은 1~%d글자이어야 합니다.", MAXIMUM_NAME_RANGE));
        }
    }
}
