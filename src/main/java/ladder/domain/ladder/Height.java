package ladder.domain.ladder;

import ladder.exception.InvalidHeightRangeException;

public class Height {
    private static final int MIN_HEIGHT = 1;

    private final int value;

    public Height(final int value) {
        validateHeightRange(value);
        this.value = value;
    }

    private void validateHeightRange(final int value) {
        if (value < MIN_HEIGHT) {
            throw new InvalidHeightRangeException();
        }
    }

    public int getValue() {
        return value;
    }
}
