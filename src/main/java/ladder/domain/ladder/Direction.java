package ladder.domain.ladder;

import ladder.domain.DirectionGenerator;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int movement;

    Direction(int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return movement;
    }

    public Direction next(DirectionGenerator directionGenerator) {
        if (this == RIGHT) {
            return LEFT;
        }
        return directionGenerator.generate();
    }

    public boolean isInvalidLast() {
        return this == RIGHT;
    }
}
