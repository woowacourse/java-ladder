package domain;

public class Height {
    private final int height;

    public Height(final int height) {
        validateRange(height);
        this.height = height;
    }

    private void validateRange(final int height) {
        if (height < 1 || height > 10) {
            throw new IllegalArgumentException("사다리의 높이는 1이상 10이하 이어야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
