package laddergame.domain;

public class LadderHeight {
    private final int value;

    public LadderHeight(final int value) {
        validatePositive(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validatePositive(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력값은 양수만 가능합니다.");
        }
    }
}
