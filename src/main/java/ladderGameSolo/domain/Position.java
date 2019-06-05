package ladderGameSolo.domain;

import java.util.Objects;

public class Position {
    private final int position;
    private final int max;

    public Position(int position, int max) {
        if (position < 0 || position > max) {
            throw new IllegalArgumentException();
        }

        this.position = position;
        this.max = max;
    }

    public boolean isLessThanMax() {
        return position < max;
    }

    int getPosition() {
        return position;
    }

    Position nextPosition() {
        return new Position(this.position + 1, max);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position &&
                max == position1.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, max);
    }
}
