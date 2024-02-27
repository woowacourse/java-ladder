package domain.ladder;

public class Height {

    private static final int MIN_LADDER_HEIGHT = 1;

    private final int height;

    public Height(int height) {
        validateLadderHeight(height);

        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    private void validateLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }
}
