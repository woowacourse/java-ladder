package domain;


public class Height {

    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 10;
    public static final String INVALID_HEIGHT_RANGE = "사다리의 높이는 " + MINIMUM_HEIGHT + "이상 " + MAXIMUM_HEIGHT + "이하 이어야 합니다.";
    private final int value;

    public Height(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < MINIMUM_HEIGHT || value > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(INVALID_HEIGHT_RANGE);
        }
    }

    public int getValue() {
        return value;
    }
}
