package domain.player;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public Position createSame() {
        return new Position(position);
    }

    public void moveRight() {
        position++;
    }

    public void moveLeft() {
        position--;
    }

    public boolean isSamePosition(int other) {
        return position == other;
    }

    public int getPosition() {
        return position;
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
