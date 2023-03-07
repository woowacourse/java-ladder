package laddergame.model.ladder;

public class Point {
    private final Direction left;
    private final Direction right;

    public Point(Direction left, Direction right) {
        this.left = left;
        this.right = right;
    }

    public int moveDirection(int position) {
        if (isRightConnect()) {
            return position + 1;
        }
        if (isLeftConnect()) {
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

    public boolean isLeftConnect() {
        return getLeft().isConnect();
    }

    public boolean isRightConnect() {
        return getRight().isConnect();
    }
}
