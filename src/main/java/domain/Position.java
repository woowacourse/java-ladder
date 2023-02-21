package domain;

public class Position {

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position left() {
        return new Position(position - 1);
    }

    public Position right() {
        return new Position(position + 1);
    }

    public boolean isInBetween(int fromInclusive, int toInclusive) {
        return fromInclusive <= position && position <= toInclusive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position1 = (Position)o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }

    public int getPosition() {
        return position;
    }
}
