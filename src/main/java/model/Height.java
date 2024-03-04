package model;

import exception.Message;

public record Height(int value) {
    private static final int UPPER_BOUND = 12;

    public Height {
        validate(value);
    }

    private void validate(final int value) {
        if (isOutOfRange(value)) {
            throw new IllegalArgumentException(Message.INVALID_HEIGHT_ERROR.getValue());
        }
    }

    private boolean isOutOfRange(final int value) {
        return value <= 0 || value > UPPER_BOUND;
    }
}
