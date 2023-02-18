package domain.value;

import java.util.Objects;

public class Position {

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position of(final int value) {
        return new Position(value);
    }

    public int value() {
        return value;
    }

    public boolean isNegative() {
        return value < 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Position move(final Direction direction) {
        if (direction == Direction.LEFT) {
            return new Position(this.value - 1);
        }
        if (direction == Direction.RIGHT) {
            return new Position(this.value + 1);
        }
        return this;
    }
}
