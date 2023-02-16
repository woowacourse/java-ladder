package ladder.domain;

import java.text.MessageFormat;

public class Height {

    private static final int MINIMUM_HEIGHT = 2;
    private static final int MAXIMUM_HEIGHT = 10;
    private static final String INVALID_HEIGHT_ERROR_MESSAGE
            = "높이는 " + MINIMUM_HEIGHT + "이상, " + MAXIMUM_HEIGHT + "이하여야 합니다. 현재 높이는 {0}입니다.";

    private final int value;

    public Height(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (hasShort(value) || hasLong(value)) {
            throw new IllegalArgumentException(MessageFormat.format(INVALID_HEIGHT_ERROR_MESSAGE, value));
        }
    }

    private boolean hasShort(final int value) {
        return value < MINIMUM_HEIGHT;
    }

    private boolean hasLong(final int value) {
        return MAXIMUM_HEIGHT < value;
    }

    public int getValue() {
        return value;
    }
}
