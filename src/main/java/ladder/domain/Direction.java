package ladder.domain;

public class Direction {
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_NONE = 0;

    private final boolean right;

    private final boolean current;

    public Direction(final boolean current, final boolean right) {
        validateDirection(current, right);
        this.current = current;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("방향은 둘다 참이 될 수 없습니다.");
        }
    }

    public int move() {
        if (current) {
            return MOVE_LEFT;
        }
        if (right) {
            return MOVE_RIGHT;
        }
        return MOVE_NONE;
    }

    public boolean isCurrent() {
        return current;
    }

    public boolean isRight() {
        return right;
    }
}
