package domain;

import static message.ErrorMessage.INVALID_LADDER_HEIGHT_EXCEPTION;

public class Height {

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_EXCEPTION.getMessageWithCause(height));
        }
    }

    public int getHeight() {
        return height;
    }
}
