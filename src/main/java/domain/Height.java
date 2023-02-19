package domain;

public class Height {
    private static final String ERROR_MIN_HEIGHT = "[ERROR] 높이는 2 이상이어야 합니다";
    private static final String ERROR_MAX_HEIGHT = "[ERROR] 높이는 100 까지만 생성 가능합니다";
    private static final int MIN_HEIGHT_INCLUSIVE = 2;
    private static final int MAX_HEIGHT_INCLUSIVE = 100;

    private final int value;

    public Height(int value) {
        validateHeightSize(value);
        this.value = value;
    }

    private static void validateHeightSize(int value) {
        if (value < MIN_HEIGHT_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MIN_HEIGHT);
        }
        if (value > MAX_HEIGHT_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MAX_HEIGHT);
        }
    }

    public int getValue() {
        return this.value;
    }
}
