package domain.ladder;

public class Height {

    protected static final int MIN_LADDER_HEIGHT = 1;
    protected static final String MIN_HEIGHT_MESSAGE = String.format("사다리의 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT);
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
            throw new IllegalArgumentException(MIN_HEIGHT_MESSAGE);
        }
    }
}
