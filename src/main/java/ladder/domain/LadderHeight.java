package ladder.domain;

public record LadderHeight(int value) {
    static final int MIN_LADDER_HEIGHT = 2;

    public LadderHeight {
        validateRange(value);
    }

    private void validateRange(final int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format("사다리 크기는 %d 이상이어야 합니다.", MIN_LADDER_HEIGHT)
            );
        }
    }
}
