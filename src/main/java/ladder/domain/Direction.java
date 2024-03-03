package ladder.domain;

import java.util.function.Function;

public enum Direction {

    BACKWARD(Index::decrease),
    FORWARD(Index::increase),
    STAY(Index::maintain);

    private final Function<Index, Index> movement;

    Direction(Function<Index, Index> movement) {
        this.movement = movement;
    }

    public Index move(Index index) {
        return movement.apply(index);
    }

    public boolean isBackward() {
        return this == BACKWARD;
    }

    public boolean isForward() {
        return this == FORWARD;
    }

    public boolean isStay() {
        return this == STAY;
    }
}
