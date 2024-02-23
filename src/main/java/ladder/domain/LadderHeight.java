package ladder.domain;

public record LadderHeight(int ladderHeight) {
    private static final int MINIMUM_LADDER_HEIGHT_LIMIT = 2;
    private static final int MAXIMUM_LADDER_HEIGHT_LIMIT = 10;

    public LadderHeight {
        validateRange(ladderHeight);
    }

    private void validateRange(final int ladderHeight) {
        if (ladderHeight < MINIMUM_LADDER_HEIGHT_LIMIT || ladderHeight > MAXIMUM_LADDER_HEIGHT_LIMIT) {
            throw new IllegalArgumentException("사다리 크기는 " + MINIMUM_LADDER_HEIGHT_LIMIT + " ~ " + MAXIMUM_LADDER_HEIGHT_LIMIT + " 범위만 가능합니다.");
        }
    }
}
