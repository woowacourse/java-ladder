package ladder.domain;

import java.util.Random;

public enum Direction {
    NONE(position -> position),
    LEFT(position -> position.prev()),
    RIGHT(position -> position.next());

    private static final Random RANDOM = new Random();
    private final PositionCreator creator;

    Direction(PositionCreator creator) {
        this.creator = creator;
    }

    public Position nextPosition(Position p) {
        return creator.create(p);
    }

    public Direction next() {
        if (this.equals(Direction.RIGHT)) {
            return Direction.LEFT;
        }
        return RANDOM.nextBoolean() ? Direction.RIGHT : Direction.NONE;
    }

    public Direction end() {
        if (this.equals(Direction.RIGHT)) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }
}
