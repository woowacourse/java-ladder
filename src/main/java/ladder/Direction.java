package ladder;

import java.util.List;
import java.util.function.UnaryOperator;

public enum Direction {

    LEFT(Index::decrement),
    RIGHT(Index::increment),
    STRAIGHT(UnaryOperator.identity());

    static {
        LEFT.pairDirections = List.of(STRAIGHT, RIGHT);
        STRAIGHT.pairDirections = List.of(STRAIGHT, RIGHT);
        RIGHT.pairDirections = List.of(LEFT);
    }

    private final UnaryOperator<Index> function;

    private List<Direction> pairDirections;

    Direction(UnaryOperator<Index> function) {
        this.function = function;
    }

    public Index apply(Index index) {
        return function.apply(index);
    }

    public boolean isInvalidPairWith(Direction direction) {
        return !pairDirections.contains(direction);
    }

    public Direction next(boolean isAttemptingToConnect) {
        if (this == RIGHT) {
            return LEFT;
        }
        if (isAttemptingToConnect) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    public Direction nextAsLast() {
        if (this == RIGHT) {
            return LEFT;
        }
        return STRAIGHT;
    }
}
