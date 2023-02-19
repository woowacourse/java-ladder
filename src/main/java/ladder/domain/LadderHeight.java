package ladder.domain;

public class LadderHeight {

    private static final int HEIGHT_LOWER_BOUND_INCLUSIVE = 2;
    private static final String HEIGHT_ERROR_MESSAGE = "높이가 2이상이어야 합니다.";
    private final int ladderHeight;

    public LadderHeight(int ladderHeight) {
        validateHeight(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    private void validateHeight(int height) {
        if (height < HEIGHT_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
