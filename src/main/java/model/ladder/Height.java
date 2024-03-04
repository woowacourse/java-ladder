package model.ladder;


public class Height {
    protected static final String NOT_ALLOWED_NEGATIVE_HEIGHT = "최대 사다리의 높이는 양수가 되어야 합니다 예: 3";

    private final int height;

    public Height(int height) {
        validateHeightIsNotNegative(height);
        this.height = height;
    }

    private void validateHeightIsNotNegative(int maximumHeight) {
        if (maximumHeight <= 0) {
            throw new IllegalArgumentException(NOT_ALLOWED_NEGATIVE_HEIGHT);
        }
    }

    public int getValue() {
        return height;
    }
}
