package laddergame.ladder;

public class LadderWidth {
    private static final int WIDTH_LOWER_BOUND_INCLUSIVE = 1;
    private final int ladderWidth;

    public LadderWidth(int ladderWidth) {
        validateWidthInRange(ladderWidth);
        this.ladderWidth = ladderWidth;
    }

    private void validateWidthInRange(int width) {
        if (width < WIDTH_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException("너비가 1 이상이어야 한다.");
        }
    }

    public int getLadderWidth() {
        return ladderWidth;
    }
}
