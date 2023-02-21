package laddergame.domain.height;

import static laddergame.domain.message.ErrorMessage.INVALID_HEIGHT_RANGE;
import static laddergame.domain.message.ErrorMessage.INVALID_HEIGHT_TYPE;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10_000;

    private final int heightNumber;

    public Height(final String height) {
        final int heightNumber = toHeightNumber(height);
        validateHeightRange(heightNumber);
        this.heightNumber = heightNumber;
    }

    private int toHeightNumber(final String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_HEIGHT_TYPE.getMessage());
        }
    }

    private void validateHeightRange(final int heightNumber) {
        if (heightNumber < MIN_HEIGHT || heightNumber > MAX_HEIGHT) {
            throw new IllegalArgumentException(INVALID_HEIGHT_RANGE.getMessage());
        }
    }

    public int getHeightNumber() {
        return heightNumber;
    }
}
