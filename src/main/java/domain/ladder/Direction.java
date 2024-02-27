package domain.ladder;

public enum Direction {
    LEFT(-1),
    MID(0),
    RIGHT(1);

    private final int direction;

    Direction(final int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
