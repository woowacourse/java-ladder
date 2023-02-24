package ladder.domain;

import java.util.function.IntUnaryOperator;

public enum Direction {
    LEFT(value -> value - 1),
    RIGHT(value -> value + 1),
    STRAIGHT(value -> value);

    private final IntUnaryOperator nextIndexFunction;

    Direction(IntUnaryOperator nextIndexFunction) {
        this.nextIndexFunction = nextIndexFunction;
    }

    public int nextIndex(int index) {
        return nextIndexFunction.applyAsInt(index);
    }
}
