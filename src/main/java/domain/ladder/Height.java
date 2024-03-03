package domain.ladder;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;

public class Height {
    private static final int MIN = 5;
    private static final int MAX = 10;
    private final int length;

    public Height(int length) {
        validate(length);
        this.length = length;
    }

    int getLength() {
        return length;
    }

    private void validate(int length) {
        if (length < MIN || length > MAX) {
            throw new LadderGameException(ExceptionType.INVALID_HEIGHT_RANGE);
        }
    }
}
