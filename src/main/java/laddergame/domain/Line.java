package laddergame.domain;

public class Line {

    private static final String MIN_WIDTH_MESSAGE = "너비는 1보다 작을 수 없습니다.";
    private static final int MIN_WIDTH = 1;

    private final int width;

    public Line(final int width) {
        validateMinWidth(width);
        this.width = width;
    }

    private void validateMinWidth(final int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalStateException(MIN_WIDTH_MESSAGE);
        }
    }
}
