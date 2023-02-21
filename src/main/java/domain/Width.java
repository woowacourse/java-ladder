package domain;

public class Width {

    private static final int MAX_WIDTH = 9;
    private static final int MIN_WIDTH = 1;
    private static final String INVALID_LADDER_WIDTH_MESSAGE = "사다리의 너비는 1~9만 가능합니다.";
    private final int width;
    public Width(int width) {
        validateWidthRange(width);
        this.width = width;
    }

    private void validateWidthRange(int width) {
        if (width > MAX_WIDTH || width < MIN_WIDTH) {
            throw new IllegalArgumentException(INVALID_LADDER_WIDTH_MESSAGE);
        }
    }

    public int getWidth() {
        return width;
    }
}
