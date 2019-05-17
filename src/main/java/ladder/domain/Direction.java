package ladder.domain;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean current;
    public Direction(boolean left, boolean current) {
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

    public Direction next(boolean nextCurrent) {
        return new Direction(this.current,nextCurrent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
