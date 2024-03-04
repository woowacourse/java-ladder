package model.ladder;

public class LadderHeight {

    private static final int MIN_HEIGHT_VALUE = 1;
    private static final String INVALID_HEIGHT_VALUE = "사다리 높이는 1이상입니다.";

    private final int value;

    public LadderHeight(int value) {
        validateHeightValue(value);
        this.value = value;
    }

    private void validateHeightValue(int height) {
        if (height < MIN_HEIGHT_VALUE) {
            throw new IllegalArgumentException(INVALID_HEIGHT_VALUE);
        }
    }

    public int getValue() {
        return value;
    }
}
