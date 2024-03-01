package domain;

import java.util.List;

public class Point {

    private final boolean left;
    private final boolean right;

    public Point(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리는 양쪽으로 연결될 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }


    public int move() {
        if (left) {
            return -1;
        } else if (right) {
            return 1;
        }
        return 0;
    }
}
