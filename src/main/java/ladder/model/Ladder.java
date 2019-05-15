package ladder.model;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private final int height;

    public Ladder(int height) {
        if (this.isValidHeight(height)) {
            throw new IllegalArgumentException("높이는 1 이상의 정수이어야 합니다.");
        }
        this.height = height;
    }

    private boolean isValidHeight(int height) {
        return height >= MIN_LADDER_HEIGHT;
    }

}
