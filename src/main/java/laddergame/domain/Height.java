package laddergame.domain;

public class Height {
    private static final int HEIGHT_MIN_VALUE = 1;
    private static final String HEIGHT_ILLEGAL_VALUE_EXCEPTION = "높이는 양수여야합니다.";

    private final int value;

    public Height(final int value) {
        validatePositive(value);
        this.value = value;
    }

    private void validatePositive(final int value) {
        if (value < HEIGHT_MIN_VALUE) {
            throw new IllegalArgumentException(HEIGHT_ILLEGAL_VALUE_EXCEPTION);
        }
    }

    public int getValue() {
        return value;
    }
}
