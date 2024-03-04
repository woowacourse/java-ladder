package model.ladder;

import exception.Message;
import java.util.Objects;

public class Height {
    private static final int UPPER_BOUND = 12;

    private final int value;

    public Height(int value) {
        Validator.validate(value);
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int size() {
        return value;
    }

    private static class Validator {
        private static void validate(int value) {
            if (isOutOfRange(value)) {
                throw new IllegalArgumentException(Message.INVALID_HEIGHT_ERROR.getMessage());
            }
        }

        private static boolean isOutOfRange(int value) {
            return value <= 0 || value > UPPER_BOUND;
        }
    }
}
