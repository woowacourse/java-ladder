package laddergame.domain;

import static laddergame.messsages.ExceptionMessages.HEIGHT_ILLEGAL_VALUE_EXCEPTION;

public class Height {
    private final int value;

    public Height(final int value) {
        validateHeight(value);
        this.value = value;
    }

    private void validateHeight(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(HEIGHT_ILLEGAL_VALUE_EXCEPTION.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
