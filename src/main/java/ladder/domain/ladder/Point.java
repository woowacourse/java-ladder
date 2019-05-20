package ladder.domain.ladder;

import java.util.Objects;

class Point {
    private final Direction direction;
    private final int position;

    private Point(final int position, final Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    static Point firstPoint(final boolean tmp) {
        return new Point(0, Direction.firstDirection(tmp));
    }

    Point nextPoint(final int maxPosition, final boolean tmp) {
        if (maxPosition > position + 1) {
            return new Point(position + 1, direction.nextDirection(tmp));
        }
        if (maxPosition == position + 1) {
            return new Point(position + 1, direction.lastDirection());
        }
        throw new IllegalArgumentException();
    }

    static Point of(final int position, final Direction direction) {
        return new Point(position, direction);
    }

    int nextPointPosition() {
        return position + direction.move();
    }

    boolean isRightDirection() {
        return direction.equals(Direction.of(false, true));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return direction.equals(point.direction)
                && position == point.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}