package ladder.domain.ladder;

import java.util.Objects;

class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    static Direction firstDirection(final boolean right) {
        return new Direction(false, right);
    }

    static Direction of(final boolean left, final boolean right) {
        return new Direction(left, right);
    }

    Direction nextDirection(final boolean injectionValue) {
        return new Direction(right, (!right && injectionValue));
    }

    Direction lastDirection() {
        return new Direction(right, false);
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