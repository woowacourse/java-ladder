package model;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
