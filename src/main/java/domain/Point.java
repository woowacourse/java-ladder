package domain;

import java.util.Objects;
import java.util.function.UnaryOperator;

public class Point {
    private final Direction direction;

    public Point(final Direction direction) {
        this.direction = direction;
    }

    public Index move(final Index index) {
        UnaryOperator<Index> converter = direction.getConverter();
        return converter.apply(index);
    }

    public boolean invalidConnection(final Point other) {
        boolean case1 = direction == Direction.RIGHT && other.direction != Direction.LEFT;
        boolean case2 = direction != Direction.RIGHT && other.direction == Direction.LEFT;
        return case1 || case2;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Point point = (Point) o;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

    public Direction getDirection() {
        return direction;
    }
}
