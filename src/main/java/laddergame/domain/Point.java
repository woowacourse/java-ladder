package laddergame.domain;

import laddergame.domain.rule.Rule;

import java.util.Objects;

public class Point {
    private boolean canMoveLeft;
    private boolean canMoveRight;

    public Point(boolean canMoveLeft, boolean canMoveRight) {
        if (canMoveLeft && canMoveRight) {
            throw new IllegalArgumentException("양쪽으로 이동은 불가능합니다.");
        }
        this.canMoveLeft = canMoveLeft;
        this.canMoveRight = canMoveRight;
    }

    public static Point first(Rule rule) {
        return new Point(false, rule.canCreate());
    }

    public Point next(Rule rule) {
        if (canMoveRight) {
            return new Point(true, false);
        }
        return new Point(false, rule.canCreate());
    }

    public Point last() {
        return new Point(this.canMoveRight, false);
    }

    public int move(int position) {
        if (canMoveLeft) {
            return position - 1;
        }
        if (canMoveRight) {
            return position + 1;
        }
        return position;
    }

    public boolean canMoveRight() {
        return canMoveRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return canMoveLeft == point.canMoveLeft &&
                canMoveRight == point.canMoveRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(canMoveLeft, canMoveRight);
    }
}
