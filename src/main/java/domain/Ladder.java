package domain;

public class Ladder {

    public static final int MAX_HEIGHT = 10;
    public static final int MIN_HEIGHT = 2;

    public Ladder(final int height) {
        validateLadderHeight(height);
    }

    private static void validateLadderHeight(final int height) {
        validateMinHeight(height);
        validateMaxHeight(height);
    }

    private static void validateMaxHeight(final int height) {
        if (MAX_HEIGHT < height) {
            throw new IllegalArgumentException("사다리 높이는 10 이하여야 합니다.");
        }
    }

    private static void validateMinHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 2 이상이어야 합니다.");
        }
    }
}
