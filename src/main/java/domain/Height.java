package domain;

import exception.ErrorCode;

public class Height {
    private static final int MIN_HEIGHT = 2;
    private static final int MAX_HEIGHT = 100;
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_UNDER_2.getMessage());
        }
        if (height > MAX_HEIGHT) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_OVER_100.getMessage());
        }
    }

    public int getHeight() {
        return height;
    }
}
