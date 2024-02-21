package ladder.domain.ladder;

import ladder.exception.ErrorMessage;
import ladder.exception.InvalidInputException;

public class Height {
    public static final int MINIMUM_HEIGHT = 1;
    private final int height;

    public Height(final int height) {
        validateHeightRange(height);
        this.height = height;
    }

    private void validateHeightRange(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new InvalidInputException(ErrorMessage.INVALID_LADDER_HEIGHT_RANGE);
        }
    }

    public int getHeight() {
        return height;
    }
}
