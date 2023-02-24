package laddergame.ladder;

public class LadderHeight {

    private static final int HEIGHT_LOWER_BOUND_INCLUSIVE = 2;

    private final int ladderHeight;

    public LadderHeight(int ladderHeight) {
        validateHeightInRange(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    private void validateHeightInRange(int height) {
        if (height < HEIGHT_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException("높이가 2이상이어야 합니다.");
        }
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
