package model;

import exception.WrongRangeLadderHeightException;

public class Height {

    private static final int MINIMUM_LADDER_HEIGHT = 1;

    private int height;

    public Height(int height) {
        validateHeight(height);

        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new WrongRangeLadderHeightException();
        }
    }

    public boolean isContinueMakeLadder() {
        return height-- > 0;
    }
}
