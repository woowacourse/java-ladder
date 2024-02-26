package ladder.domain;

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
}
