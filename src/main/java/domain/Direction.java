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

    public static Direction generate(final Direction beforeDirection, final boolean condition) {
        if (beforeDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.next(condition);
    }

    public static Direction generateFirst(final boolean condition) {
        return Direction.next(condition);
    }

    public static Direction generateLast(final Direction beforeDirection) {
        if (beforeDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.STRAIGHT;
    }

    public static Direction next(final boolean condition) {
        if (condition) {
            return RIGHT;
        }
        return STRAIGHT;
    }
}
