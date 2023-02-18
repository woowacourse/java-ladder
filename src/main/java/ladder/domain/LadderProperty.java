package ladder.domain;

public class LadderProperty {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 1000;
    private static final String HEIGHT_RANGE_EXCEPTION_MESSAGE = "[ERROR] 사다리의 높이는 1 이상 1000 이하여야합니다.";

    private final int width;
    private final int height;

    public LadderProperty(final int width, final int height) {
        this.width = width;
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(final int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }
}
