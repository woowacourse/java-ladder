package ladder.domain;

import java.util.function.Function;

public enum Direction {

    LEFT(Index::decrease),
    RIGHT(Index::increase),
    DOWN(index -> index);

    private final Function<Index, Index> movement;

    Direction(Function<Index, Index> movement) {
        this.movement = movement;
    }

    public Index move(Index index) {
        return movement.apply(index);
    }
}
