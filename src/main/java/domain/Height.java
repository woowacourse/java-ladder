package domain;

import exception.ErrorMessage;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;

    private final int value;

    public Height(final int value) {
        validateHeight(value);
        this.value = value;
    }

    private void validateHeight(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_EXCEPTION.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
