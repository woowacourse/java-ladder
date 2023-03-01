package ladder.domain.ladder;

import java.util.Objects;

public class PointCopy {

    public Position moveDirection(final Position currentPosition) {

        if (direction == SecondDirection.RIGHT) {
            return currentPosition.increase();
        }
        if (direction == SecondDirection.LEFT) {
            return currentPosition.decrease();
        }
        return currentPosition;
    }

    public PointCopy next(final boolean next) {
        if (this.right && next) {
            throw new IllegalArgumentException("양쪽으로 연결될 수 없습니다");
        }

        return new PointCopy(this.right, next);
    }

    public PointCopy last() {
        if (right) {
            return new PointCopy(SecondDirection.LEFT);
        }

        return new PointCopy(SecondDirection.DOWN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointCopy point = (PointCopy) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
