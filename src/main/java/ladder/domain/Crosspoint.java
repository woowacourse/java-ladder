package ladder.domain;

import java.util.Objects;

public class Crosspoint {
    private static final int ONE_STEP_LEFT = -1;
    private static final int ONE_STEP_RIGHT = 1;
    private static final int STAY = 0;
    private final int movingVector;

    public Crosspoint(boolean leftCrossbar, boolean rightCrossbar) {
        validateCrossbar(leftCrossbar, rightCrossbar);
        this.movingVector = (leftCrossbar || rightCrossbar) ? setMovingVectorBy(leftCrossbar) : STAY;
    }

    private Crosspoint(int movingVector) {
        this.movingVector = movingVector;
    }

    static Crosspoint addFirst(boolean rightCrossbar) {
        if (rightCrossbar) {
            return new Crosspoint(ONE_STEP_RIGHT);
        }
        return new Crosspoint(STAY);
    }

    static Crosspoint addPoint(boolean prevBoolean, boolean nextBoolean) {
        return new Crosspoint((prevBoolean || nextBoolean) ? setMovingVectorBy(prevBoolean) : STAY);
    }

    static Crosspoint addLast(boolean prevBoolean) {
        if(prevBoolean){
            return new Crosspoint(ONE_STEP_LEFT);
        }
        return new Crosspoint(STAY);
    }

    private static int setMovingVectorBy(boolean prevBoolean) {
        if (prevBoolean) {
            return ONE_STEP_LEFT;
        }
            return ONE_STEP_RIGHT;
    }


    private void validateCrossbar(boolean leftCrossbar, boolean rightCrossbar) {
        if (leftCrossbar && rightCrossbar) {
            throw new IllegalArgumentException("양쪽 모두 가로 막대가 있을 수는 없습니다.");
        }
    }

    public int answerResultPositionOf(int positionOfPlayer) {
        return positionOfPlayer + movingVector;
    }

    public boolean hasRightSideCrossbar() {
        return movingVector == ONE_STEP_RIGHT;
    }

    @Override
    public String toString() {
        return String.valueOf(movingVector);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crosspoint that = (Crosspoint) o;
        return movingVector == that.movingVector;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movingVector);
    }
}
