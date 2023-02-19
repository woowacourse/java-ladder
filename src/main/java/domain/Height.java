package domain;

public class Height {
    private static final String ERROR_HEIGHT_RANGE = "[ERROR] 사다리의 높이는 2 ~ 100 사이로 생성 가능합니다";
    private static final int MIN_HEIGHT_INCLUSIVE = 2;
    private static final int MAX_HEIGHT_INCLUSIVE = 100;

    private final int value;

    public Height(int value) {
        validateHeightSize(value);
        this.value = value;
    }

    private static void validateHeightSize(int value) {
        if (value < MIN_HEIGHT_INCLUSIVE || value > MAX_HEIGHT_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_HEIGHT_RANGE);
        }
    }

    public int getValue() {
        return this.value;
    }
}
