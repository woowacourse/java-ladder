package domain;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(final boolean left, final boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Point of(final boolean left, final boolean right) {
        return new Point(left, right);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Point point = (Point) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
