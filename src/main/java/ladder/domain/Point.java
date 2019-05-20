package ladder.domain;

public class Point {
    static final int LEFT = -1;
    static final int STRAIGHT = 0;
    static final int RIGHT = 1;

    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        validateNotConsecutiveTrue(left, current);
        this.left = left;
        this.current = current;
    }

    private void validateNotConsecutiveTrue(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("사다리 선이 가로로 연속적일 수 없습니다.");
        }
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean right) {
        return new Point(this.current, right);
    }

    public Point last() {
        return new Point(current, false);
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

    public boolean getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return "Point{" +
                "left=" + left +
                ", current=" + current +
                '}';
    }

}
