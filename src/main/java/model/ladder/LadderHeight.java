package model.ladder;

public record LadderHeight(int value) {
    private static final int MIN_VALUE_OF_HEIGHT = 1;
    private static final String INVALID_VALUE_OF_HEIGHT = "사다리 높이는 1이상입니다.";

    public LadderHeight {
        validateValueOfHeight(value);
    }

    private void validateValueOfHeight(int height) {
        if (height < MIN_VALUE_OF_HEIGHT) {
            throw new IllegalArgumentException(INVALID_VALUE_OF_HEIGHT);
        }
    }
}
