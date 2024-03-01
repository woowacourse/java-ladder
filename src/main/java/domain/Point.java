package domain;

public class Point {
    private final Direction direction;
    private final int index;

    public Point(Direction direction) {
        this(direction, 0);
    }

    public Point(Direction direction, int index) {
        this.direction = direction;
        this.index = index;
    }

    public Point next() {
        if (direction == Direction.LEFT) {
            return new Point(Direction.RIGHT, index - 1);
        }
        if (direction == Direction.RIGHT) {
            return new Point(Direction.LEFT, index + 1);
        }
        return new Point(Direction.STRAIGHT, index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (index != point.index) {
            return false;
        }
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + index;
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "direction=" + direction +
                ", index=" + index +
                '}';
    }
}
