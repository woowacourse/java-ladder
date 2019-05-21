package ladder.domain.ladder;


import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean current;

    Direction(final boolean left, final boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.current = current;
    }

    public int move() {
        if (this.left) {
            return -1;
        }
        if (this.current) {
            return 1;
        }
        return 0;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean current) {
        return new Direction(false, current);
    }

    public Direction last() {
        return new Direction(this.current, false);
    }

    public Direction next(boolean nextCurrent) {
        if (this.current) {
            return of(this.current, false);
        }
        return of(this.current, nextCurrent);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Direction direction = (Direction) o;
        return left == direction.left &&
                current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
