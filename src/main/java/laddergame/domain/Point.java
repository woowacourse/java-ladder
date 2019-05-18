package laddergame.domain;

import laddergame.domain.rule.Rule;

import java.util.Objects;

public class Point {
    private int position;
    private boolean canMoveLeft;
    private boolean canMoveRight;

    public Point(int position, boolean canMoveLeft, boolean canMoveRight) {
        if (canMoveLeft && canMoveRight) {
            throw new IllegalArgumentException("양쪽으로 이동은 불가능합니다.");
        }
        this.position = position;
        this.canMoveLeft = canMoveLeft;
        this.canMoveRight = canMoveRight;
    }

    public static Point first(Rule rule) {
        return new Point(0, false, rule.canCreate());
    }

    public Point last() {
        return new Point(this.position + 1, this.canMoveRight, false);
    }

    public Point next(Rule rule) {
        if (canMoveRight) {
            return new Point(position + 1, true, false);
        }
        return new Point(position + 1, false, rule.canCreate());
    }

    public int move() {
        if (canMoveLeft) {
            return position - 1;
        }
        if (canMoveRight) {
            return position + 1;
        }
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position &&
                canMoveLeft == point.canMoveLeft &&
                canMoveRight == point.canMoveRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, canMoveLeft, canMoveRight);
    }
}
