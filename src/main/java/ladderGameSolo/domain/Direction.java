package ladderGameSolo.domain;

import java.util.Objects;

public class Direction {
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_NONE = 0;

    private boolean left;
    private boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.right = right;
    }

    public int move() {
        if (this.left) {
            return MOVE_LEFT;
        }

        if (this.right) {
            return MOVE_RIGHT;
        }

        return MOVE_NONE;
    }

    boolean checkStatus() {
        return move() != 0;
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
