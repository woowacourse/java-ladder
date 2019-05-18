package ladder.domain.ladder;

import java.util.Objects;

public class Direction {
    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction firstDirection(boolean tmp) {
        return new Direction(false, tmp);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction nextDirection(boolean injectionValue) {
        return new Direction(right, (!right && injectionValue));
    }

    public Direction lastDirection() {
        return new Direction(right, false);
    }

    public int move() {
        if (left) {
            return -1;
        }
        if (right) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}