package domain;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(final boolean left, final boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽에 모두 다리가 있을 수 없습니다.");
        }
    }

    public static Point of(final boolean left, final boolean right) {
        return new Point(left, right);
    }

    public int move(final int index) {
        if (right) {
            return index + 1;
        }
        if (left) {
            return index -1;
        }
        return index;
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
