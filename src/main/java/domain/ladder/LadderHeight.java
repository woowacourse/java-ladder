package domain.ladder;

import common.exception.model.ValidationException;

public class LadderHeight {
    public static final String RANGE_ERROR_MESSAGE = String.format("사다리 높이의 범위는 %d 이상, %d 이하여야 합니다",
            LadderHeight.HEIGHT_MIN, LadderHeight.HEIGHT_MAX);
    public static final int HEIGHT_MIN = 2;
    public static final int HEIGHT_MAX = 10;

    private final int value;

    public LadderHeight(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int height) {
        if (height < HEIGHT_MIN || height > HEIGHT_MAX) {
            throw new ValidationException(RANGE_ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
