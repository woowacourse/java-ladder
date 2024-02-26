package ladder.domain.ladder;

public class Height {
    private static final int MIN_HEIGHT = 1;

    private final int value;

    public Height(final int value) {
        validateHeightRange(value);
        this.value = value;
    }

    private void validateHeightRange(final int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 1 이상의 정수입니다.");
        }
    }

    public boolean isGreaterThan(final int ladderStepsHeight) {
        return value > ladderStepsHeight;
    }
}
