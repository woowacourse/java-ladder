/*
 * @(#)Point.java
 *
 * v 1.1.0
 *
 * 2019.05.20
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain.ladder;

import java.util.Objects;

import ladder.domain.utils.RandomGenerator;

/**
 * Horizontal 의 한 칸을 나타내는 클래스
 *
 * @author kwonmc
 * @version 1.1.0
 */
public class Point {
    private Direction left;
    private Direction right;

    private Point(Direction left, Direction right) {
        this.left = left;
        this.right = right;
    }

    private static Point of(Direction first, Direction second) {
        return new Point(first, second);
    }

    public Direction getLeft() {
        return left;
    }

    static Point first() {
        return of(new Direction(false), RandomGenerator.get());
    }

    private Point next(Direction nextCurrent) {
        return of(right, nextCurrent);
    }

    Point next() {
        if (right.equals(Direction.empty())) {
            return next(RandomGenerator.get());
        }
        return next(Direction.empty());
    }

    Point last() {
        return next(Direction.empty());
    }

    Boolean canMoveLeft() {
        return left.is();
    }

    Boolean canMoveRight() {
        return right.is();
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
}
