package ladder.domain;

import java.util.Objects;

public class Direction {
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_STRAIGHT = 0;

    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("연속 true 불가능");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(final boolean left, final boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(final boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(this.right, false);
    }

    public Direction next(final boolean right) {
        if (this.right) {
            return of(true, false);
        }
        return of(false, right);
    }

    public int move() {
        if (left) {
            return MOVE_LEFT;
        }
        if (right) {
            return MOVE_RIGHT;
        }
        return MOVE_STRAIGHT;
    }

    public boolean isRight() {
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
