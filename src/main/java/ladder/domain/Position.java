package ladder.domain;

import java.util.Objects;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public void move(Direction direction) {
        value += direction.getMoveValue();
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
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
