package domain;

public class Ladder {

    private static final int MIN_HEIGHT = 1;

    public Ladder(int height) {
        validateHeight(height);
    }

    private static void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }
}
