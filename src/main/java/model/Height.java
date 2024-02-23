package model;

import exception.Message;
import java.util.Objects;

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

    private boolean isOutOfRange(int value) {
        return value <= 0 || value > UPPER_BOUND;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
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
