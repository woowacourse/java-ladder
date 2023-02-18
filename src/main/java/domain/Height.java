package domain;

public class Height {

    private static final int HEIGHT_LOWER_BOUND = 1;
    private static final int HEIGHT_UPPER_BOUND = 10;

    private final int height;

    public Height(final int height) {
        validate(height);
        this.height = height;
    }

    private void validate(final int height) {
        if (height < HEIGHT_LOWER_BOUND || height > HEIGHT_UPPER_BOUND) {
            throw new IllegalArgumentException();
        }
    }

    public int getHeight() {
        return height;
    }
}
