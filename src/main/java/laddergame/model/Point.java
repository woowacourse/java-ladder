package laddergame.model;

public class Point {
    private final Direction left;
    private final Direction right;

    public Point(Direction left, Direction right) {
        this.left = left;
        this.right = right;
    }

    public int moveDirection(int position) {
        if (getLeftIsBoolean() && (position - 1 < 0)) {
            throw new IllegalArgumentException("더이상 왼쪽으로 이동할 수 없습니다.");
        }
        if (getRightIsBoolean()) {
            return position + 1;
        }
        if (getLeftIsBoolean()) {
            return position - 1;
        }
        return position;
    }

    private Direction getLeft() {
        return this.left;
    }

    public Direction getRight() {
        return this.right;
    }

    public boolean getLeftIsBoolean() {
        return getLeft().isDirection();
    }

    public boolean getRightIsBoolean() {
        return getRight().isDirection();
    }
}
