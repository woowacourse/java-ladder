package domain;

import java.util.Objects;

public class Position {

    private final int index;

    public Position(int index) {
        this.index = index;
    }

    public Position increase() {
        return new Position(index + 1);
    }

    public Position decrease() {
        return new Position(index - 1);
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return index == position.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
