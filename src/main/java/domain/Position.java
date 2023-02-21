package domain;

import java.util.Objects;

public class Position {
    public static final int INITIAL_VALUE = 0;
    private int column;
    private int row;

    public Position(int column) {
        this.column = column;
        this.row = INITIAL_VALUE;
    }

    public void goDown() {
        this.row++;
    }

    public void goLeft() {
        this.column--;
    }

    public void goRight() {
        this.column++;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return column == position.column && row == position.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    @Override
    public String toString() {
        return "Position{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }
}
