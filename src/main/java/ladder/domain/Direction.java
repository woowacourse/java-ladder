package ladder.domain;

public enum Direction {
    LEFT(true, false),
    RIGHT(false, true),
    NONE(false, false);

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Position nextPosition(Position position) {
        return position.plus(getInt());
    }

    private int getInt() {
        if (left) {
            return -1;
        }
        if (right) {
            return 1;
        }
        return 0;
    }
}
