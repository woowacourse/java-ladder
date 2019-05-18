package ladder.domain.ladder;

import java.util.Objects;

public class Point {
    private int position;
    private boolean left;
    private boolean right;

    public Point(int position, boolean left, boolean right) {
        this.position = position;
        this.left = left;
        this.right = getRight(left, right);
    }

    public Point(Point point, int max, boolean availablePoint) {
        this.position = point.position + 1;
        this.left = point.right;
        this.right = getRight(left, availablePoint, max);
    }

    private boolean getRight(boolean left, boolean availablePoint, int max) {
        if (max == position) return false;
        if (left == false && availablePoint == true) {
            return true;
        }
        return false;
    }

    private boolean getRight(boolean left, boolean right) {
        if (left == false && right == true) {
            return true;
        }
        return false;
    }

    public int nextPointPosition() {
        if (left) {
            return position - 1;
        }
        if (right) {
            return position + 1;
        }
        return position;
    }

    public boolean getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return right == point.right
                && left == point.left
                && position == point.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                position + Boolean.hashCode(left) + Boolean.hashCode(right)
        );
    }
}