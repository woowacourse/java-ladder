package domain;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public boolean isDown() {
        return direction == Direction.DOWN;
    }
}
