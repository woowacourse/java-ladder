package ladder.domain;

import ladder.utils.RandomValueUtils;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽이 동시에 연결될 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public Direction next(boolean nextRight) {
        return new Direction(right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return next(RandomValueUtils.generate());
    }

    public static Direction first() {
        return new Direction(false, RandomValueUtils.generate());
    }

    public Direction last() {
        return new Direction(right, false);
    }

    public boolean isConnectedToLeft() {
        return left;
    }

    public boolean isConnectedToRight() {
        return right;
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
