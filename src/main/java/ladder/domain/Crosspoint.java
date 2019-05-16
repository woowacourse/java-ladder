package ladder.domain;

public class Crosspoint {
    private static final int ONE_STEP_LEFT = -1;
    private static final int ONE_STEP_RIGHT = 1;
    private static final int STAY = 0;
    private final int movingVector;

    public Crosspoint(boolean leftCrossbar, boolean rightCrossbar) {
        validateCrossbar(leftCrossbar, rightCrossbar);
        this.movingVector = leftCrossbar ? ONE_STEP_LEFT
                : (rightCrossbar ? ONE_STEP_RIGHT : STAY);
    }

    private void validateCrossbar(boolean leftCrossbar, boolean rightCrossbar) {
        if (leftCrossbar && rightCrossbar) {
            throw new IllegalArgumentException("양쪽 모두 가로 막대가 있을 수는 없습니다.");
        }
    }

    public int answerResultPositionOf(int positionOfPlayer) {
        return positionOfPlayer + movingVector;
    }
}
