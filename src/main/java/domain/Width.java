package domain;

public class Width {

    private static final int MAX_WIDTH = 9;
    private static final int MIN_WIDTH = 1;
    private final int width;
    public Width(int width) {
        validateWidthRange(width);
        this.width = width;
    }

    private void validateWidthRange(int width) {
        if (width > MAX_WIDTH || width < MIN_WIDTH) {
            throw new IllegalArgumentException("");
        }
    }

    public int getWidth() {
        return width;
    }
}
