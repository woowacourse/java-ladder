package laddergame.model;

public class Point {
    private final Direction left;
    private final Direction right;

    public Point(Direction left, Direction right) {
        this.left = left;
        this.right = right;
    }

    public int moveDirection(int position) {
        if (position - 1 < 0) {
            throw new IllegalArgumentException("[ERROR] 더이상 왼쪽으로 이동할 수 없습니다.");
        }
        if (right.isDirection()) {
            return position + 1;
        }
        if (left.isDirection()) {
            return position - 1;
        }
        return position;
    }

    private Direction getLeft() {
        return left;
    }

    public Direction getRight() {
        return right;
    }

    public boolean getLeftIsBoolean() {
        return getLeft().isDirection();
    }

    public boolean getRightIsBoolean() {
        return getRight().isDirection();
    }
}
