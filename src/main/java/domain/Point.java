package domain;

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
}
