package ladder.domain;

import java.util.Objects;

public class Direction {
    private static final int LEFT_MOVE = -1;
    private static final int NONE_MOVE = 0;
    private static final int RIGHT_MOVE = 1;

    private final boolean left;
    private final boolean current;

    private Direction(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.current = current;
    }

    public int move() {
        if (this.left) {
            return LEFT_MOVE;
        }

        if (this.current) {
            return RIGHT_MOVE;
        }

        return NONE_MOVE;
    }

    public Direction next(boolean nextCurrent) {
        return new Direction(this.current, nextCurrent);
    }

    Direction next(RandomValueGenerator randomValueGenerator) {
        if (this.current) {
            return next(false);
        }

        return next(randomValueGenerator.generate());
    }

    public static Direction first(RandomValueGenerator randomValueGenerator) {
        return new Direction(false, randomValueGenerator.generate());
    }

    public Direction last() {
        return new Direction(this.current, false);
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

    public boolean isLeft() {
        return left;
    }
}
