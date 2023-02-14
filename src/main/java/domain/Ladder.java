package domain;

public class Ladder {
    public static final int MIN_HEIGHT = 0;

    private final int height;

    public Ladder(int height) {
        validatePositive(height);
        this.height = height;
    }

    private void validatePositive(int height) {
        if (height <= MIN_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 양의 정수여야 합니다.");
        }
    }
}
