package domain;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private static final String INVALID_HEIGHT = "사다리 높이는 1 이상의 정수여야 합니다.";
    private final int height;

    public Height(final int value) {
        validateHeight(value);
        this.height = value;
    }

    private void validateHeight(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException(INVALID_HEIGHT);
        }
    }

    public int getValue() {
        return height;
    }
}
