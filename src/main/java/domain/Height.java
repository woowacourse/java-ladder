package domain;

public class Height {
    private static final int MIN_HEIGHT = 1;

    private final int height;

    public Height(final int value) {
        validateHeight(value);
        this.height = value;
    }

    private void validateHeight(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1이상만 입력할 수 있습니다.");
        }
    }

    public int getValue() {
        return height;
    }
}
