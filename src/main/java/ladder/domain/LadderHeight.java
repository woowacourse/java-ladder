package ladder.domain;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;

    private final int value;

    public LadderHeight(int value) {
        this.value = value;
        validateMin(this.value);
    }

    private static void validateMin(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상의 정수이어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
