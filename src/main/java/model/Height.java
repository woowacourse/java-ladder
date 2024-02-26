package model;

import exception.Message;

public record Height(int value) {
    private static final int UPPER_BOUND = 12;

    public Height {
        validate(value);
    }

    private void validate(int value) {
        if (isOutOfRange(value)) {
            throw new IllegalArgumentException(Message.INVALID_HEIGHT_ERROR.getMessage());
        }
    }

    private boolean isOutOfRange(int value) {
        return value <= 0 || value > UPPER_BOUND;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Height height)) {
            return false;
        }
        return value == height.value;
    }
}
