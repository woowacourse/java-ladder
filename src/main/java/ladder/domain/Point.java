package ladder.domain;

import java.util.Random;

public class Point {
    private static final String CROSS_BAR = "-----";
    private static final String UNCROSS_BAR = "     ";

    private boolean left;
    private int position;
    private boolean right;

    Point(boolean left, int position, boolean right) {
        checkSameTrue(left, right);
        this.left = left;
        this.position = position;
        this.right = right;
    }

    private void checkSameTrue(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
    }

    public static Point firstPoint() {
        return new Point(false, 0, new Random().nextBoolean());
    }

    public static Point nextPoint(Point point) {
        return new Point(point.right, point.position + 1, !point.right && new Random().nextBoolean());
    }

    public static Point lastPoint(Point point) {
        return new Point(point.right, point.position + 1, false);
    }

    int move() {
        if (this.left) {
            return -1;
        }
        if (this.right) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return right ? CROSS_BAR : UNCROSS_BAR;
    }


}
