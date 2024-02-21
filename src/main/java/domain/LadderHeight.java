package domain;

import common.exception.message.ExceptionMessage;

public class LadderHeight {
    private final int value;

    public static final int HEIGHT_MIN_RANGE = 2;
    public static final int HEIGHT_MAX_RANGE = 10;

    public LadderHeight(String value) {

        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INTEGER_FORMAT);
        }
        int height = Integer.parseInt(value);

        if (height < HEIGHT_MIN_RANGE || height > HEIGHT_MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.LADDER_HEIGHT_RANGE);
        }
        this.value = height;
    }

    public int getValue() {
        return value;
    }
}
