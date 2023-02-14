package domain;

public class Ladder {
    private final int height;

    public Ladder(int height) {
        validatePositive(height);
        this.height = height;
    }

    private void validatePositive(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 양의 정수여야 합니다.");
        }
    }
}
