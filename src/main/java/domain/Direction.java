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

    public static Direction generate(final Direction beforeDirection, final PointState state) {
        if (beforeDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.next(state);
    }

    public static Direction generateFirst(final PointState state) {
        return Direction.next(state);
    }

    public static Direction generateLast(final Direction beforeDirection) {
        if (beforeDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.STRAIGHT;
    }

    public static Direction next(final PointState state) {
        if (state == PointState.CONNECT_NEXT_POINT) {
            return RIGHT;
        }
        return STRAIGHT;
    }
}
