package domain;

import java.util.Objects;

public class Column {

    private int column;

    public Column(int column) {
        this.column = column;
    }

    public static Column of(int column) {
        return new Column(column);
    }

    public void goLeft() {
        this.column--;
    }

    public void goRight() {
        this.column++;
    }

    public int get() {
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
        Column column1 = (Column) o;
        return column == column1.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column);
    }

    @Override
    public String toString() {
        return "Column{" +
                "column=" + column +
                '}';
    }
}
