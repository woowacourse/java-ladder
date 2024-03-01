package domain;

import java.util.Objects;
import java.util.function.UnaryOperator;

public class Point {
    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Index move(Index index) {
        UnaryOperator<Index> converter = direction.getConverter();
        return converter.apply(index);
    }

    public boolean invalidConnection(Point other) {
        return direction == Direction.RIGHT && other.direction != Direction.LEFT;
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
}
