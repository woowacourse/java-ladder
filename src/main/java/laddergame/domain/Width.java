package laddergame.domain;

public class Width {
    private static final int WIDTH_MIN_VALUE = 1;
    private static final String WIDTH_ILLEGAL_VALUE_EXCEPTION = "넓이는 양수여야합니다.";

    private final int value;

    public Width(final int value) {
        validatePositive(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validatePositive(final int value) {
        if (value < WIDTH_MIN_VALUE) {
            throw new IllegalArgumentException(WIDTH_ILLEGAL_VALUE_EXCEPTION);
        }
    }
}
