package laddergame.model.ladder;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        validateRange(height);
        this.height = height;
    }

    private static void validateRange(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 " + MIN_HEIGHT + "이상이어야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
