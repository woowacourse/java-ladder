package ladder.domain;

public class Point {
    private Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public int move() {
        if (direction.isConnectedToLeft()) {
            return -1;
        }
        if (direction.isConnectedToRight()) {
            return 1;
        }
        return 0;
    }

    public boolean isConnectedToRight() {
        return direction.isConnectedToRight();
    }
}
