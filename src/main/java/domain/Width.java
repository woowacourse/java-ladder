package domain;

public class Width {
    private static final String ERROR_MIN_WIDTH = "[ERROR] 너비는 1 이상이어야 합니다";
    private static final int ZERO = 0;
    private final int value;

    public Width(final int value) {
        validateWidthSize(value);
        this.value = value;
    }

    private void validateWidthSize(final int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException(ERROR_MIN_WIDTH);
        }
    }

    public int getValue() {
        return this.value;
    }
}
