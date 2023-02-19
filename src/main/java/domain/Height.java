package domain;

import exception.ErrorCode;

public class Height {
    private static final int HEIGHT_LIMIT = 2;
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < HEIGHT_LIMIT) {
            throw new IllegalArgumentException(ErrorCode.NEGATIVE_NUMBER.getMessage());
        }
    }

    public int getHeight() {
        return height;
    }
}
