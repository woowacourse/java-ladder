package ladder.domain;

import java.util.Objects;

public class Crosspoint {
    private static final int ONE_STEP_LEFT = -1;
    private static final int ONE_STEP_RIGHT = 1;
    private static final double RATE_OF_EMPTY_CROSSBARS = 0.5;

    private final boolean leftCrossbar;
    private final boolean rightCrossbar;

    Crosspoint(boolean leftCrossbar, boolean rightCrossbar) {
        validateCrossbar(leftCrossbar, rightCrossbar);
        this.leftCrossbar = leftCrossbar;
        this.rightCrossbar = rightCrossbar;
    }

    private void validateCrossbar(boolean leftCrossbar, boolean rightCrossbar) {
        if (leftCrossbar && rightCrossbar) {
            throw new IllegalArgumentException("양쪽 모두 가로 막대가 있을 수는 없습니다.");
        }
    }

    static Crosspoint generateFirstCrosspoint() {
        return new Crosspoint(false, generateCrossbarRandomly());
    }

    private static boolean generateCrossbarRandomly() {
        return Math.random() > RATE_OF_EMPTY_CROSSBARS;
    }

    static Crosspoint generateInnerCrosspointNeighboredWith(Crosspoint leftNeighboredCrossbar) {
        Crosspoint leftHandCrosspoint = new Crosspoint(true, false);
        Crosspoint randomCrosspointWithoutLeftHand = new Crosspoint(false, generateCrossbarRandomly());

        return leftNeighboredCrossbar.hasRightSideCrossbar() ? leftHandCrosspoint : randomCrosspointWithoutLeftHand;
    }

    static Crosspoint generateLastCrosspointNeighboredWith(Crosspoint leftNeighboredCrossbar) {
        return new Crosspoint(leftNeighboredCrossbar.hasRightSideCrossbar(), false);
    }

    int answerResultPositionOf(int positionOfPlayer) {
        return (leftCrossbar || rightCrossbar) ? move(positionOfPlayer) : positionOfPlayer;
    }

    private int move(int positionOfPlayer) {
        return leftCrossbar ? positionOfPlayer + ONE_STEP_LEFT : positionOfPlayer + ONE_STEP_RIGHT;
    }

    boolean hasRightSideCrossbar() {
        return rightCrossbar;
    }

    boolean hasLeftSideCrossbar() {
        return leftCrossbar;
    }

    boolean hasCrossbar() {
        return leftCrossbar || rightCrossbar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crosspoint that = (Crosspoint) o;
        return leftCrossbar == that.leftCrossbar &&
                rightCrossbar == that.rightCrossbar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftCrossbar, rightCrossbar);
    }
}
