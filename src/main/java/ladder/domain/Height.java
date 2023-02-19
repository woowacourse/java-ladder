package ladder.domain;

public class Height {
    private static final int MIN_HEIGHT = 0;
    private static final int MAX_HEIGHT = 26;

    private final int height;

    public Height(int height) {
        validatePositive(height);
        this.height = height;
    }

    private void validatePositive(int height) {
        if (isProperHeight(height)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 1~26 사이여야 합니다.");
        }
    }

    private static boolean isProperHeight(int height) {
        return height <= MIN_HEIGHT || height > MAX_HEIGHT;
    }

    public int getHeight() {
        return height;
    }
}
