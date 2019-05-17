package com.woowacourse.ladder.domain;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(final boolean left, final boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public static Direction middle(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        return new Direction(left, right);
    }

    public static Direction last(boolean left) {
        return new Direction(left, false);
    }

    public int move() {
        if (this.right) {
            return 1;
        }
        if (this.left) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
