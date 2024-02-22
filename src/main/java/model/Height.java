package model;

import exception.Message;

public class Height {

    private static final int UPPER_BOUND = 12;

    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (isOutOfRange(value)) {
            throw new IllegalArgumentException(Message.INVALID_HEIGHT_ERROR.getMessage());
        }
    }

    boolean isOutOfRange(int value) {
        return value <= 0 || value > UPPER_BOUND;
    }

    public int getValue() {
        return value;
    }
}
