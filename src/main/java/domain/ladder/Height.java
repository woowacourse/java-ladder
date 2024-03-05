package domain.ladder;

public class Height {
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 50;

    private final int height;

    public Height(int height) {
        validateRange(height);
        this.height = height;
    }

    private void validateRange(int height) {
        if (height < MINIMUM_HEIGHT || MAXIMUM_HEIGHT < height) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %d - %d이상 %d이하의 높이만 가능합니다.",
                            height, MINIMUM_HEIGHT, MAXIMUM_HEIGHT));
        }
    }

    public int getValue() {
        return this.height;
    }
}
