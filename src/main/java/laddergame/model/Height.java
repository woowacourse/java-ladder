package laddergame.model;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private static final String ERROR_HEIGHT_LENGTH = "사다리의 높이는 " + MIN_HEIGHT + "이상이어야 합니다.";
    private final int height;

    public Height(int height) {
        validateRange(height);
        this.height = height;
    }

    private static void validateRange(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ERROR_HEIGHT_LENGTH);
        }
    }

    public int getHeight() {
        return height;
    }
}
