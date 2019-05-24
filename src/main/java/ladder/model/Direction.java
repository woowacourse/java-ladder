package ladder.model;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (left & right) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.right = right;
    }

    static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    static Direction first(boolean right) {
        return new Direction(false, right);
    }

    Direction next(boolean right) {
        if (this.right & right) {
            right = false;
        }
        return new Direction(this.right, right);
    }

    Direction last() {
        return new Direction(this.right, false);
    }

    int move() {
        if (left) {
            return -1;
        }
        if (right) {
            return 1;
        }
        return 0;
    }
}
