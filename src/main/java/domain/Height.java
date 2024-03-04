package domain;

import static message.ErrorMessage.INVALID_LADDER_HEIGHT_EXCEPTION;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_EXCEPTION.getMessage());
        }
    }

    public int getHeight() {
        return height;
    }
}
