package ladder.domain;

public class Height {

    private static final int HEIGHT_LOWER_BOUND_INCLUSIVE = 2;
    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < HEIGHT_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
    }

    public int getHeight() {
        return height;
    }
}
