package ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    NEUTRAL(0);

    private final int positionChange;

    Direction(final int positionChange) {
        this.positionChange = positionChange;
    }

    public Position determineNextPosition(final Position position) {
        final int nextPosition = position.value() + positionChange;
        return new Position(nextPosition);
    }
}
