package domain;

import java.util.Objects;

public class Position {

    private final int position;

    public Position(final int position) {
        this.position = position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position anotherPosition = (Position) o;
        return position == anotherPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }
}
