package ladder.model;

import java.util.Objects;

public class Direction {
    private static final int RIGHT_MOVE = 1;
    private static final int LEFT_MOVE = -1;
    private static final int NONE_MOVE = 0;

    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public Direction next(boolean right) {
        if (this.right && right) {
            right = false;
        }
        return new Direction(this.right, right);
    }

    public Direction last() {
        return new Direction(this.right, false);
    }

    int move() {
        if (left) {
            return LEFT_MOVE;
        }
        if (right) {
            return RIGHT_MOVE;
        }
        return NONE_MOVE;
    }

    boolean isMovable() {
        return right;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
