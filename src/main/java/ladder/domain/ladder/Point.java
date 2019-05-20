package ladder.domain.ladder;

import java.util.Objects;

import ladder.domain.utils.RandomGenerator;

class Point {
    private Boolean left;
    private Boolean right;

    Point(Boolean left, Boolean right) {
        this.left = left;
        this.right = right;
    }

    private static Point of(Boolean first, Boolean second) {
        return new Point(first, second);
    }

    static Point first() {
        return of(false, RandomGenerator.get());
    }

    Point next(Boolean nextCurrent) {
        return of(right, nextCurrent);
    }

    Point next() {
        if (right.equals(false)) {
            return next(RandomGenerator.get());
        }
        return next(false);
    }

    Point last() {
        return next(false);
    }

    Boolean canMoveLeft() {
        return left;
    }

    Boolean canMoveRight() {
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
        return left ? "-----" : "     ";
    }
}
