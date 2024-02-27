package domain;

import common.exception.message.ExceptionMessage;

public class LadderHeight {
    public static final int HEIGHT_MIN_RANGE = 2;
    public static final int HEIGHT_MAX_RANGE = 10;

    private final int value;

    public LadderHeight(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int height) {
        if (height < HEIGHT_MIN_RANGE || height > HEIGHT_MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.LADDER_HEIGHT_RANGE);
        }
    }

    public int getValue() {
        return value;
    }
}
