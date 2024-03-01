package model.players;

import java.util.Objects;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public Position moveRight() {
        return new Position(value + 1);
    }

    public Position moveLeft() {
        return new Position(value - 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
