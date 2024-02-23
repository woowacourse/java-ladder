package domain;

import static message.ErrorMessage.INVALID_LADDER_WIDTH_EXCEPTION;

public class Width {

    private final int width;

    public Width(int width) {
        validate(width);
        this.width = width;
    }

    private void validate(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException(INVALID_LADDER_WIDTH_EXCEPTION.getMessage());
        }
    }
}
