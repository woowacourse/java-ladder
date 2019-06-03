package ladder.domain.ladder;

import java.util.Objects;

public class Direction {
    private final boolean hasLeft;
    private final boolean hasRight;

    public Direction(final boolean hasLeft, final boolean hasRight) {
        checkDirection(hasLeft, hasRight);
        this.hasLeft = hasLeft;
        this.hasRight = hasRight;
    }

    private void checkDirection(boolean hasLeft, boolean hasRight) {
        if (hasLeft && hasRight) {
            throw new IllegalArgumentException("방향을 두 개 이상 가질 수 없습니다.");
        }
    }

    public static Direction first(boolean hasRight) {
        return new Direction(false, hasRight);
    }

    public Direction next(boolean hasNext) {
        if (hasRight) {
            return of(true, false);
        }
        return of(false, hasNext);
    }

    public static Direction of(boolean hasLeft, boolean hasRight) {
        return new Direction(hasLeft, hasRight);
    }

    public Direction last() {
        return new Direction(hasRight, false);
    }

    public int move() {
        if (hasLeft) {
            return -1;
        }
        if (hasRight) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return hasLeft == direction.hasLeft &&
                hasRight == direction.hasRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasLeft, hasRight);
    }

    @Override
    public String toString() {
        if (hasRight) {
            return "-----";
        }
        return "     ";
    }
}