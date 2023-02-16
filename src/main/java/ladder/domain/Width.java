package ladder.domain;

public class Width {
    private static final int WIDTH_LOWER_BOUND_INCLUSIVE = 2;
    private final int width;

    public Width(int width) {
        validateWidth(width);
        this.width = width;
    }

    private void validateWidth(int width) {
        if (width < WIDTH_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
    }

    public int getWidth() {
        return width;
    }
}
