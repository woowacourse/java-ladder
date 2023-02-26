package domain;

public enum Direction {
    RIGHT(1),
    DOWN(0),
    LEFT(-1);

    private final int direction;

    Direction(final int direction) {
        this.direction = direction;
    }

    public int getDirectionWeight() {
        return direction;
    }
}
