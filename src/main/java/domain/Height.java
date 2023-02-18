package domain;

public class Height {
    private static final String ERROR_MIN_HEIGHT = "[ERROR] 높이는 2 이상이어야 합니다";
    private static final String ERROR_MAX_HEIGHT = "[ERROR] 높이는 100 까지만 생성 가능합니다";
    private static final int MIN_HEIGHT_INCLUSIVE = 2;
    private static final int MAX_HEIGHT_INCLUSIVE = 100;

    private final int height;

    public Height(int height) {
        validateHeightSize(height);
        this.height = height;
    }

    private static void validateHeightSize(int height) {
        if (height < MIN_HEIGHT_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MIN_HEIGHT);
        }
        if (height > MAX_HEIGHT_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_MAX_HEIGHT);
        }
    }

    public int getValue() {
        return this.height;
    }
}
