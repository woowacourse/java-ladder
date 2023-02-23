package laddergame.domain.ladder;

import laddergame.domain.util.ExceptionMessageFormatter;

public class LadderHeight {

    private static final int MIN_VALUE = 1;

    private final int value;

    public LadderHeight(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        String message = String.format("사다리 높이는 %d 이상이어야 합니다.", MIN_VALUE);
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(message, value));
        }
    }

    public int get() {
        return value;
    }
}
