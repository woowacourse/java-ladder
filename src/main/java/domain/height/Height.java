package domain.height;

public class Height {
    private static final String RANGE_EXCEPTION_MESSAGE = "[ERROR] 잘못된 높이: %d - %d이상 %d이하의 숫자만 입력 가능합니다.";
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 50;

    private final int height;

    public Height(final int height) {
        validateRange(height);
        this.height = height;
    }

    private void validateRange(int height) {
        if (height < MINIMUM_HEIGHT || height > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format(RANGE_EXCEPTION_MESSAGE, height, MINIMUM_HEIGHT, MAXIMUM_HEIGHT));
        }
    }

    public int getValue() {
        return this.height;
    }
}
