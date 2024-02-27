package domain;

public enum Direction {
    LEFT(-1),
    INPLACE(0),
    RIGHT(1);

    private final int direction;

    Direction(final int moveIndex) {
        this.direction = moveIndex;
    }

    public int getDirection() {
        return direction;
    }
}
