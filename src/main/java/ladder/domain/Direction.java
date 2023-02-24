package ladder.domain;

import java.util.function.IntUnaryOperator;

public enum Direction {
    LEFT(value -> value - 1),
    RIGHT(value -> value + 1),
    STRAIGHT(value -> value);

    private final IntUnaryOperator moveFunction;

    Direction(IntUnaryOperator moveFunction) {
        this.moveFunction = moveFunction;
    }

    public int move(int index) {
        return moveFunction.applyAsInt(index);
    }
}
