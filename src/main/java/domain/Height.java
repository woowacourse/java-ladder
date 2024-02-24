package domain;

import util.ExceptionMessages;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 10;
    private final int value;

    public Height(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < MINIMUM_HEIGHT || value > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_HEIGHT_RANGE);
        }
    }

    public int getValue() {
        return value;
    }
}
