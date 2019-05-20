package ladder.domain.ladder;

import java.util.Objects;

import ladder.domain.RandomGenerator;

public class Point {
    private Boolean left;
    private Boolean right;

    public Point(Boolean left, Boolean right) {
        this.left = left;
        this.right = right;
    }

    private static Point of(Boolean first, Boolean second) {
        return new Point(first, second);
    }

    public static Point first() {
        return of(false, RandomGenerator.get());
    }

    public Point next(Boolean nextCurrent) {
        return of(right, nextCurrent);
    }

    public Point next() {
        if (right.equals(false)) {
            return next(RandomGenerator.get());
        }
        return next(false);
    }

    public Point last() {
        return next(false);
    }

    public Boolean canMoveLeft() {
        return left;
    }

    public Boolean canMoveRight() {
        return right;
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
        return right ? "-----" : "     ";
    }
}
