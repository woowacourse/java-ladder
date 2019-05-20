package laddergame.domain;

import laddergame.domain.rule.Rule;

import java.util.Objects;

public class Point {
    private Direction left;
    private Direction right;

    public Point(boolean canMoveLeft, boolean canMoveRight) {
        if (canMoveLeft && canMoveRight) {
            throw new IllegalArgumentException("양쪽으로 이동은 불가능합니다.");
        }
        this.left = new Direction(canMoveLeft);
        this.right = new Direction(canMoveRight);
    }

    public static Point first(Rule rule) {
        return new Point(false, rule.canCreate());
    }

    public Point next(Rule rule) {
        if (right.canMove()) {
            return new Point(true, false);
        }
        return new Point(false, rule.canCreate());
    }

    public Point last() {
        return new Point(right.canMove(), false);
    }

    public int move(int position) {
        if (left.canMove()) {
            return position - 1;
        }
        if (right.canMove()) {
            return position + 1;
        }
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(left, point.left) &&
                Objects.equals(right, point.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return left + "|" + right;
    }
}
