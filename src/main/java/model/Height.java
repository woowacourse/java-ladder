package model;


public class Height {
    protected static final String NOT_POSITIVE_HEIGHT = "최대 사다리의 높이는 양수가 되어야 합니다";

    private final int height;

    public Height(int height) {
        validateHeightIsPositive(height);
        this.height = height;
    }

    private void validateHeightIsPositive(int maximumHeight) {
        if (maximumHeight < 0) {    // 0을 상수화?
            throw new IllegalArgumentException(NOT_POSITIVE_HEIGHT);
        }
    }

    public int getValue() {
        return height;
    }
}
