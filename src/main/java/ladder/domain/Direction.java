package ladder.domain;

import java.util.Objects;

public class Direction {
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_NONE = 0;

    private final boolean left;
    private final boolean right;

    public Direction(final boolean left, final boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("방향은 둘다 참이 될 수 없습니다.");
        }
    }

    public int move() {
        if (left) {
            return MOVE_LEFT;
        }
        if (right) {
            return MOVE_RIGHT;
        }
        return MOVE_NONE;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
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
