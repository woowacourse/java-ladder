package ladder.domain;

import static ladder.constant.ErrorMessage.MIN_LADDER_HEIGHT;
import static ladder.constant.ErrorMessage.NUMERIC_LADDER_HEIGHT;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;
    private static final String NUMERIC_REGEX = "-?\\d+(\\.\\d+)?";

    private final int value;

    private LadderHeight(int value) {
        this.value = value;
        validateMin(this.value);
    }

    public static LadderHeight from(String height) {
        String strippedHeight = height.strip();
        validateNumeric(strippedHeight);
        return new LadderHeight(Integer.parseInt(strippedHeight));
    }

    private static void validateNumeric(String height) {
        if (!height.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(NUMERIC_LADDER_HEIGHT.generate());
        }
    }

    private static void validateMin(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException(MIN_LADDER_HEIGHT.generate());
        }
    }

    public int getValue() {
        return value;
    }
}
