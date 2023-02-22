package domain;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
    }

    public boolean getRight() {
        return right;
    }

    public int calculateMoveValue() {
        if (left && !right) {
            return -1;
        }

        if (!left && right) {
            return 1;
        }

        return 0;
    }
}
