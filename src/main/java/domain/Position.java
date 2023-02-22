package domain;

class Position {

    private final int position;

    Position(int position) {
        this.position = position;
    }

    Position moveTo(Direction direction) {
        if (direction.isLeft()) {
            return left();
        }
        if (direction.isRight()) {
            return right();
        }
        return new Position(position);
    }

    Position left() {
        return new Position(position - 1);
    }

    Position right() {
        return new Position(position + 1);
    }

    boolean isInBetween(int fromInclusive, int toExclusive) {
        return fromInclusive <= position && position < toExclusive;
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

    int getPosition() {
        return position;
    }
}
