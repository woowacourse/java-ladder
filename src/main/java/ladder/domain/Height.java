package ladder.domain;

public class Height {
    private static final int MIN_SIZE = 2;
    private final int height;

    public Height(int height) {
        validateRange(height);
        this.height = height;
    }

    private void validateRange(int height) {
        if (height < MIN_SIZE ) {
            throw new IllegalArgumentException("높이는 2 이상이어야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
