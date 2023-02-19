package ladder.domain;

public class LadderWidth {
    private static final int WIDTH_LOWER_BOUND_INCLUSIVE = 1;
    private static final String WIDTH_ERROR_MESSAGE = "너비가 1 이상이어야 한다.";
    private final int ladderWidth;

    public LadderWidth(int ladderWidth) {
        validateWidth(ladderWidth);
        this.ladderWidth = ladderWidth;
    }

    private void validateWidth(int width) {
        if (width < WIDTH_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(WIDTH_ERROR_MESSAGE);
        }
    }

    public int getLadderWidth() {
        return ladderWidth;
    }
}
