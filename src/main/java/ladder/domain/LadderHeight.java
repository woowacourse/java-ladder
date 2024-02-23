package ladder.domain;

import static ladder.constant.ErrorMessage.MIN_LADDER_HEIGHT;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;

    private final int value;

    public LadderHeight(int value) {
        this.value = value;
        validateMin(this.value);
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
