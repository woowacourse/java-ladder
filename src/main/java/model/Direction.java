package model;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int offset;

    Direction(int offset) {
        this.offset = offset;
    }

    public int move(int position) {
        return position + this.offset;
    }
}
