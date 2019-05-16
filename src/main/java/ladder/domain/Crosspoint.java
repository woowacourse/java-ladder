package ladder.domain;

public class Crosspoint {
    private static final int ONE_STEP_LEFT = -1;
    private static final int ONE_STEP_RIGHT = 1;
    private static final int STAY = 0;
    private final int movingVector;

    public Crosspoint(boolean leftCrossbar, boolean rightCrossbar) {
        this.movingVector = leftCrossbar ? ONE_STEP_LEFT
                : (rightCrossbar ? ONE_STEP_RIGHT : STAY);
    }

    public int answerResultPositionOf(int positionOfPlayer) {
        return positionOfPlayer + movingVector;
    }
}
