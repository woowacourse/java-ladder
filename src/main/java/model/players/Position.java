package model.players;

import java.util.Objects;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public int moveRight() {
        value++;
        return value;
    }

    public int moveLeft() {
        value--;
        return value;
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

    public int getValue() {
        return value;
    }
}
