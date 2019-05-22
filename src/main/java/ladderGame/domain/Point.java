package ladderGame.domain;

public class Point {
    private Direction direction;

    private Point(Direction direction) {
        this.direction = direction;
    }

    public static Point pointFirst(boolean nextRight) {
        return new Point(Direction.makeDirection(Direction.STOP, nextRight));
    }

    public Point nextPointLast() {
        return new Point(Direction.makeDirection(direction, false));
    }

    public Point nextPoint(boolean nextRight) {
        return new Point(Direction.makeDirection(direction, nextRight));
    }

    public boolean isHasRight() {
        return direction == Direction.RIGHT;
    }

    public int move() {
        return direction.getDistance();
    }
}
