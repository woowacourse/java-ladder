package domain.wrapper;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    private Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Position from(final int x) {
        return new Position(x, 0);
    }

    public static Position of(final int x, final int y) {
        return new Position(x, y);
    }

    public void addX() {
        x = x + 1;
    }

    public void subX() {
        x = x - 1;
    }

    public void addY() {
        y = y + 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
