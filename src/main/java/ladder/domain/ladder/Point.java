package ladder.domain.ladder;

import java.util.Objects;

class Point {
    private final Direction direction;
    private final int position;

    private Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    static Point firstPoint(boolean tmp) {
        return new Point(0, Direction.firstDirection(tmp));
    }

    Point nextPoint(int maxPosition, boolean tmp) {
        if (maxPosition > position + 1) {
            return new Point(position + 1, direction.nextDirection(tmp));
        }
        if (maxPosition == position + 1) {
            return new Point(position + 1, direction.lastDirection());
        }
        throw new IllegalArgumentException();
    }

    static Point of(int position, Direction direction) {
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