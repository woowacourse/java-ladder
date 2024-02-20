package laddergame.domain;

public class LadderHeight {
    private final int height;

    public LadderHeight(final int input) {
        validatePositive(input);
        this.height = input;
    }

    private void validatePositive(final int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력값은 양수만 가능합니다.");
        }
    }

    public boolean isNot(final int value) {
        return value != height;
    }

    public int getHeight() {
        return height;
    }
}
