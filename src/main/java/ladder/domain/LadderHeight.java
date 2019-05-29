package ladder.domain;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;
    private static final String ERROR_NON_INPUT = "입력이 없습니다.";
    private static final String ERROR_INSUFFICIENT_HEIGHT = "사다리의 높이가 충분하지 않습니다.";
    private static final String ERROR_NEGATIVE = "사다리 높이는 자연수 입니다.";

    private final int ladderHeight;

    public LadderHeight(final String unverifiedLadderHeight) {
        checkEmpty(unverifiedLadderHeight);
        checkInts(unverifiedLadderHeight);

        int ladderHeight = Integer.parseInt(unverifiedLadderHeight);
        checkCanMakeLadder(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    private void checkEmpty(String ladderHeight) {
        if (ladderHeight == null || ladderHeight.isEmpty()) {
            throw new NullPointerException(ERROR_NON_INPUT);
        }
    }

    private void checkInts(String ladderHeight) {
        try {
            Integer.parseInt(ladderHeight);
        } catch (NumberFormatException npe) {
            throw new IllegalArgumentException(ERROR_NEGATIVE);
        }
    }

    private void checkCanMakeLadder(int ladderHeight) {
        if(ladderHeight < MIN_HEIGHT) {
            throw new IllegalArgumentException(ERROR_INSUFFICIENT_HEIGHT);
        }
    }

    boolean isCompleteLadder(final int createdLineCount) {
        return this.ladderHeight == createdLineCount;
    }
}
