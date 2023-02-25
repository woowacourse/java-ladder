package model.vo;

public class Position {
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean isSame(Position other) {
        return this.position == other.position;
    }
}
