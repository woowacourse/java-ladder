package domain;

public class LadderHeight {

    private static final int MIN_LADDER_HEIGHT = 1;

    private final int value;

    public LadderHeight(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("다리 길이는 양수여야합니다. 입력값 : %s", value));
        }
    }

    public int value() {
        return this.value;
    }
}
