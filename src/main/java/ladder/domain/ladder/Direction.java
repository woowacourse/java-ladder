package ladder.domain.ladder;

import ladder.domain.Position;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    NEUTRAL(0);

    private final int positionChange;

    Direction(int positionChange) {
        this.positionChange = positionChange;
    }

    public Position determineNextPosition(Position position) {
        int nextPosition = position.value() + positionChange;
        return new Position(nextPosition);
    }
}
