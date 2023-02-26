package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

public class Height {
    private static final int MIN_HEIGHT = 2;
    private static final int MAX_HEIGHT = 100;

    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (!isHeightIncludedInRange(height)) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_HEIGHT.getMessage());
        }
    }

    private boolean isHeightIncludedInRange(int height) {
        return MIN_HEIGHT <= height && height <= MAX_HEIGHT;
    }

    public int getHeight() {
        return height;
    }

}
