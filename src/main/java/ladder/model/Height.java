package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

public class Height {
    private static final int MIN_HEIGHT = 2;

    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_HEIGHT.getMessage());
        }
    }

    public int getHeight() {
        return height;
    }

}
