package domain.ladder;

import domain.player.Position;

public enum Step {
    NONE(0),
    LEFT(-1),
    RIGHT(1);

    private final int direction;

    Step(final int direction) {
        this.direction = direction;
    }

    public boolean isRightConnection() {
        return this == RIGHT;
    }

    public Position step(final Position currentPosition) {
        return currentPosition.move(direction);
    }
}
