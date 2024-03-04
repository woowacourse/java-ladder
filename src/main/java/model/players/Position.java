package model.players;

import java.util.Objects;
import model.laddergame.Direction;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public int move(Direction direction) {
        direction.move(this);
        return value;
    }

    public void moveRight() {
        value++;
    }

    public void moveLeft() {
        value--;
    }

    public boolean doesNotMatch(final int size) {
        return value != size;
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
