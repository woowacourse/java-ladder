package ladder.domain;

public class Width {
    private static final int WIDTH_LOWER_BOUND_INCLUSIVE = 2;
    private static final String WIDTH_ERROR_MESSAGE = "너비가 2이상이어야 합니다.";
    private final int width;

    public Width(int width) {
        validateWidth(width);
        this.width = width;
    }

    private void validateWidth(int width) {
        if (width < WIDTH_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(WIDTH_ERROR_MESSAGE);
        }
    }

    public int getWidth() {
        return width;
    }
}
