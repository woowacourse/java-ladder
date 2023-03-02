package domain.player;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int calculate(int value) {
        return position += value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Position otherPosition = (Position) other;
        return position == otherPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
