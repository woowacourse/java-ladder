package ladder.domain.ladder;

public enum Direction {
    LEFT(currentPosition -> currentPosition - 1),
    RIGHT(currentPosition -> currentPosition + 1),
    STRAIGHT(currentPosition -> currentPosition);

    private final Positioning positioning;

    Direction(Positioning positioning) {
        this.positioning = positioning;
    }

    public static Direction getDirection(Bar leftBar, Bar rightBar) {
        if (leftBar == Bar.MOVABLE_BAR) {
            return LEFT;
        }
        if (rightBar == Bar.MOVABLE_BAR) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public int move(int currentPosition) {
        return positioning.decidePosition(currentPosition);
    }

    @FunctionalInterface
    interface Positioning {
        int decidePosition(int currentPosition);
    }
}
