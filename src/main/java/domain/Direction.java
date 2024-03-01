package domain;

import java.util.function.UnaryOperator;

public enum Direction {
    LEFT(Index::decrease),
    RIGHT(Index::increase),
    STRAIGHT(UnaryOperator.identity());

    private final UnaryOperator<Index> converter;

    Direction(UnaryOperator<Index> converter) {
        this.converter = converter;
    }

    public UnaryOperator<Index> getConverter() {
        return converter;
    }

    public static Direction next(final boolean condition) {
        if (condition) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    static Direction generate(Direction beforeDirection, boolean condition) {
        if (beforeDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.next(condition);
    }
}
