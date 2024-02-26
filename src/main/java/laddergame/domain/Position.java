package laddergame.domain;

import java.sql.SQLOutput;
import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Direction direction) {
        if (direction == Direction.RIGHT) {
            x += 1;
        }
        if (direction == Direction.LEFT) {
            x -= 1;
        }
        y += 1;
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
