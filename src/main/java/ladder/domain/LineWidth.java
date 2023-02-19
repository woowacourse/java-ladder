package ladder.domain;

import ladder.util.ExceptionMessageFormatter;

public class LineWidth {

    private static final int MIN_VALUE = 1;

    private final int value;

    public LineWidth(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("사다리 폭은 " + MIN_VALUE + " 이상이어야 합니다.", value));
        }
    }

    public int get() {
        return value;
    }
}
