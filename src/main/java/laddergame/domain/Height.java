package laddergame.domain;

public class Height {
    private static final int FINISH_NUMBER = 0;
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10;
    private static final String HEIGHT_RANGE_ERROR_MESSAGE = "height 높이는 1 이상 10 이하만 가능합니다.";

    private final int height;

    public Height(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_RANGE_ERROR_MESSAGE);
        }
        this.height = height;
    }

    public boolean isPossibleCount() {
        return this.height > FINISH_NUMBER;
    }

    public int getHeight() {
        return height;
    }

    public boolean isOver(int number) {
        return height > number;
    }
}
