package model;

import constant.ExceptionMessage;

public class LadderHeight {
    private static final int MAXIMUM_LADDER_HEIGHT = 20;
    private static final int MINIMUM_LADDER_HEIGHT = 1;

    private final int height;

    public LadderHeight(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT || height > MAXIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_LADDER_HEIGHT.getExceptionMessage());
        }
    }

    public int getLadderHeight() {
        return this.height;
    }
}
