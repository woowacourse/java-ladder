package laddergame.model.laddergame;

import laddergame.exception.BaseException;

public record LadderHeight(int height) {
    private static final int MINIMUM_LADDER_HEIGHT = 1;

    public LadderHeight {
        validateLadderHeight(height);
    }

    private void validateLadderHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            String message = "사다리 높이는 1보다 작을 수 없습니다. 입력값: " + height;
            throw new BaseException(message);
        }
    }
}
