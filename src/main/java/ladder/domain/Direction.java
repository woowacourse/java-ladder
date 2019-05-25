package ladder.domain;

public enum Direction {
    NONE(position -> position),
    LEFT(position -> position.prev()),
    RIGHT(position -> position.next());

    private final PositionMover mover;

    Direction(PositionMover mover) {
        this.mover = mover;
    }

    public Position nextPosition(Position p) {
        return mover.move(p);
    }

    public Direction next(BooleanGenerator booleanGenerator) {
        if (this.equals(Direction.RIGHT)) {
            return Direction.LEFT;
        }
        return booleanGenerator.nextBoolean() ? Direction.RIGHT : Direction.NONE;
    }

    public Direction end() {
        if (this.equals(Direction.RIGHT)) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }

    @FunctionalInterface
    public interface BooleanGenerator {
        boolean nextBoolean();
    }

    @FunctionalInterface
    private interface PositionMover {
        Position move(Position position);
    }
}
