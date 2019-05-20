package laddergame.domain;

public enum Point {
    LEFT(true, false),
    RIGHT(false, true),
    STRAIGHT(false, false);

    private final boolean left;
    private final boolean right;

    Point(final boolean left, final boolean right) {
        this.left = left;
        this.right = right;
    }

    public int move(final int position) {
        if (left) {
            return position - 1;
        }
        if (right) {
            return position + 1;
        }
        return position;
    }
}
