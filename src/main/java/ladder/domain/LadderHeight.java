package ladder.domain;

public class LadderHeight {
    private final int ladderHeight;

    public LadderHeight(final int ladderHeight) {
        validateRange(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    private void validateRange(final int ladderHeight) {
        if (ladderHeight < 2 || ladderHeight > 10) {
            throw new IllegalArgumentException("사다리 크기는 2 ~ 10 범위만 가능합니다.");
        }
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
