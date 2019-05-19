package ladderGame.domain;

public class Point {
    private final boolean hasLeft;
    private final boolean hasRight;

    public Point(boolean hasLeft, boolean hasRight) {
        validatePoint(hasLeft, hasRight);
        this.hasLeft = hasLeft;
        this.hasRight = hasRight;
    }

    private void validatePoint(boolean hasLeft, boolean hasRight) {
        if (hasLeft && hasRight) {
            throw new IllegalArgumentException("가로 라인은 겹칠 수 없음");
        }
    }

    public static Point pointFirst(boolean hasRight) {
        return new Point(false, hasRight);
    }

    public Point nextPointLast() {
        if (hasRight) {
            return new Point(true, false);
        }
        return new Point(false, false);
    }

    public Point nextPoint(boolean nextRight) {
        if (hasRight) {
            return new Point(true, false);
        }
        return new Point(false, nextRight);
    }

    public boolean isHasRight() {
        return hasRight;
    }

    public boolean isHasLeft() {
        return hasLeft;
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
}
