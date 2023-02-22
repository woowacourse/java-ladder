package domain;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;

    private final int height;

    public Height(int height) {
        validatePositiveNumber(height);
        this.height = height;
    }

    private static void validatePositiveNumber(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 높이는 양수만 가능합니다.");
        }
    }

    public int getHeight() {
        return this.height;
    }
}
