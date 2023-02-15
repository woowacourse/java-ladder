package domain;

public class Ladder {

    private final int height;

    public Ladder(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < 1 || height > 100) {
            throw new IllegalArgumentException();
        }
    }
}
