package ladder.domain;

public class Width {
    private final int width;
    public Width(int width) {
        validateWidth(width);
        this.width = width;
    }

    private void validateWidth(int width) {
        if (width <= 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getWidth() {
        return width;
    }
}
