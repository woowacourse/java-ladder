package domain.ladder;

import common.exception.model.ValidationException;

public class LadderHeight {
    public static final String LADDER_HEIGHT_RANGE = String.format("사다리 높이의 범위는 %d 이상, %d 이하여야 합니다",
            LadderHeight.HEIGHT_MIN_RANGE, LadderHeight.HEIGHT_MAX_RANGE);
    public static final int HEIGHT_MIN_RANGE = 2;
    public static final int HEIGHT_MAX_RANGE = 10;

    private final int value;

    public LadderHeight(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int height) {
        if (height < HEIGHT_MIN_RANGE || height > HEIGHT_MAX_RANGE) {
            throw new ValidationException(LADDER_HEIGHT_RANGE);
        }
    }

    public int getValue() {
        return value;
    }
}
