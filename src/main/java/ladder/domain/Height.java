package ladder.domain;

public class Height {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 100;

    int height;

    public Height(int height) {
        validateLadderHeight(height);
        this.height = height;
    }

    private void validateLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT || height > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1이상 100이하여야 합니다");
        }
    }

    public int getHeight() {
        return height;
    }
}
