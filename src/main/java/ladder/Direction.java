package ladder;

import java.util.function.UnaryOperator;

public enum Direction {

    LEFT(Index::decrement),
    RIGHT(Index::increment),
    STRAIGHT(UnaryOperator.identity());

    private final UnaryOperator<Index> function;

    Direction(UnaryOperator<Index> function) {
        this.function = function;
    }

    public Index apply(Index index) {
        return function.apply(index);
    }
}
