package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;

public class LadderHeight {
    public static final int HEIGHT_MIN_RANGE = 2;
    public static final int HEIGHT_MAX_RANGE = 10;

    private final int value;

    public LadderHeight(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int height) {
        if (height < HEIGHT_MIN_RANGE || height > HEIGHT_MAX_RANGE) {
            throw new ValidationException(ExceptionMessage.LADDER_HEIGHT_RANGE);
        }
    }

    public int getValue() {
        return value;
    }
}
