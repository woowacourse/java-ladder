package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;

public class LadderHeight {
    private final int value;

    public static final int HEIGHT_MIN_RANGE = 2;
    public static final int HEIGHT_MAX_RANGE = 10;

    public LadderHeight(final String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        validateIntegerFormat(value);
        validateRange(Integer.parseInt(value));
    }

    private void validateRange(final int height) {
        if (height < HEIGHT_MIN_RANGE || height > HEIGHT_MAX_RANGE) {
            throw new ValidationException(ExceptionMessage.LADDER_HEIGHT_RANGE);
        }
    }

    private void validateIntegerFormat(final String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new ValidationException(ExceptionMessage.INTEGER_FORMAT);
        }
    }

    public int getValue() {
        return value;
    }
}
