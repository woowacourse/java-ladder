package ladder;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Index move(Index index) {
        if (direction == Direction.LEFT) {
            return index.decrement();
        }
        if (direction == Direction.RIGHT) {
            return index.increment();
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Point point = (Point) o;

        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return direction != null ? direction.hashCode() : 0;
    }
}
