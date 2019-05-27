package ladder.domain.ladder;

import java.util.Objects;

public class Point {
    private static final String VERTICAL_LINE = "-----";
    private static final String VERTICAL_EMPTY = "     ";
    private static final int NEXT_PASS_VALUE = 1;

    private final Direction direction;
    private int position;

    public Point(final Direction direction, final int position) {
        this.position = position;
        this.direction = direction;
    }

    public static Point generateFirstPoint(boolean bool) {
        return new Point(Direction.first(bool), 0);
    }

    public static Point genarateNextPoint(final Point currentPoint, final int max, final boolean availablePoint) {
        return currentPoint.nextPoint(max, availablePoint);
    }

    public int move() {
        return this.position += this.direction.move();
    }

    private Point nextPoint(final int max, final boolean nextCurrent) {
        if (max > position + NEXT_PASS_VALUE) {
            return new Point(direction.next(nextCurrent), position + NEXT_PASS_VALUE);
        }
        if (max == position + NEXT_PASS_VALUE) {
            return new Point(direction.last(), position + NEXT_PASS_VALUE);
        }
        throw new IllegalArgumentException();
    }

    public boolean isDirection() {
        return direction.equals(Direction.of(false, true));
    }

    @Override
    public String toString() {
        if (isDirection()) return VERTICAL_LINE;
        return VERTICAL_EMPTY;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return position == point.position &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, position);
    }
}
