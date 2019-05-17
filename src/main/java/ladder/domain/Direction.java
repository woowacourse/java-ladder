package ladder.domain;

public class Direction {
    static final int LEFT = -1;
    static final int STRAIGHT = 0;
    static final int RIGHT = 1;

    private final boolean left;
    private final boolean current;

    private Direction(boolean left, boolean current) {
        validateNotConsecutiveTrue(left, current);
        this.left = left;
        this.current = current;
    }

    public static Direction first(boolean current) {
        return new Direction(false, current);
    }

    public Direction next(boolean right) {
        return new Direction(this.current, right);
    }

    public Direction last() {
        return new Direction(current, false);
    }

    private void validateNotConsecutiveTrue(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("사다리 선이 가로로 연속적일 수 없습니다.");
        }
    }

    public int move() {
        if (left) {
            return LEFT;
        }

        if (current) {
            return RIGHT;
        }
        return STRAIGHT;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", current=" + current +
                '}';
    }
}
