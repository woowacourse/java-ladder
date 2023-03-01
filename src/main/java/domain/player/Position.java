package domain.player;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }


    public void increase() {
        position++;
    }

    public void decrease() {
        position--;
    }

    public boolean same(int other) {
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
