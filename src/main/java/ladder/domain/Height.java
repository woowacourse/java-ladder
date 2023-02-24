package ladder.domain;

public class Height {
    private static final int HEIGHT_LOWER_BOUND = 1;
    private static final int HEIGHT_UPPER_BOUND = 100;
    private static final String INVALID_HEIGHT_MESSAGE =
            "높이는 " + HEIGHT_LOWER_BOUND + "이상, " + HEIGHT_UPPER_BOUND + "이하의 값이어야 합니다.";

    private final int value;

    public Height(final String value) {
        this(parseInt(value));
    }

    private Height(final int value) {
        validate(value);
        this.value = value;
    }

    private static int parseInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_HEIGHT_MESSAGE);
        }
    }

    private static void validate(final int value) {
        if (isInvalidHeight(value)) {
            throw new IllegalArgumentException(INVALID_HEIGHT_MESSAGE);
        }
    }

    private static boolean isInvalidHeight(final int value) {
        return value < HEIGHT_LOWER_BOUND || HEIGHT_UPPER_BOUND < value;
    }

    public int getValue() {
        return value;
    }
}
