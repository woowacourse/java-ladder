package laddergame.model;

public class Point {
    private final Direction right;
    private final Direction left;

    public Point() {
        this.right = new Direction(false);
        this.left = new Direction(false);
    }

    public Point(Direction right, Direction left) {
        this.right = right;
        this.left = left;
    }

    public int moveDirection(int position) {
        if (position - 1 < 0) {
            throw new IllegalArgumentException("[ERROR] 더이상 왼쪽으로 이동할 수 없습니다.");
        }
        // 마지막은 무조건 false..
        if (right.isDirection()) {
            return position + 1;
        }
        if (left.isDirection()) {
            return position - 1;
        }
        return position;
    }
}
