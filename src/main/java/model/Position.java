package model;

public class Position {
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean isSamePosition(Position other) {
        return this.position == other.position;
    }
}
