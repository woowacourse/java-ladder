package domain;

public class Height {
    private static final int MIN_VALUE = 1;

    private final int height;

    public Height(int value) {
        validateRange(value);
        this.height = value;
    }

    private void validateRange(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR] 높이는 " + MIN_VALUE + " 이상이어야 합니다");
        }
    }

    public Integer getHeight() {
        return height;
    }
}
