package domain;

import static utils.ErrorMessage.INVALID_LADDER_HEIGHT_BY_MAXIMUM_LIMIT;
import static utils.ErrorMessage.INVALID_LADDER_HEIGHT_BY_MINIMUM_LIMIT;

public class Height {

    private final int MINIMUM_HEIGHT_LIMIT = 1;
    private final int MAXIMUM_HEIGHT_LIMIT = 100;
    private final int height;

    public Height(int height) {
        validateHeightByMinimumLimit(height);
        validateHeightByMaximumLimit(height);

        this.height = height;
    }

    private void validateHeightByMinimumLimit(int height) {
        if (height < MINIMUM_HEIGHT_LIMIT) {
            throw new IllegalArgumentException(
                String.format(INVALID_LADDER_HEIGHT_BY_MINIMUM_LIMIT.getMessage(),
                    MINIMUM_HEIGHT_LIMIT));
        }
    }

    private void validateHeightByMaximumLimit(int height) {
        if (height > MAXIMUM_HEIGHT_LIMIT) {
            throw new IllegalArgumentException(
                String.format(INVALID_LADDER_HEIGHT_BY_MAXIMUM_LIMIT.getMessage(),
                    MAXIMUM_HEIGHT_LIMIT));
        }
    }

    public int getHeight() {
        return height;
    }
}
