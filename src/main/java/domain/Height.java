package domain;

import static utils.ErrorMessage.INVALID_LADDER_HEIGHT_RANGE;

public class Height {
    private final int MIN_HEIGHT = 1;

    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(
                String.format(INVALID_LADDER_HEIGHT_RANGE.getMessage(), MIN_HEIGHT));
        }
    }

    public int getHeight() {
        return height;
    }
}
