package ladder.domain.ladder.size;

import ladder.exception.ladder.InvalidHeightRangeException;

public record Height(int value) {
    private static final int MIN_HEIGHT = 1;

    public Height {
        validateHeightRange(value);
    }

    private void validateHeightRange(final int value) {
        if (value < MIN_HEIGHT) {
            throw new InvalidHeightRangeException();
        }
    }
}
