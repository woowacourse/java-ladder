package ladderGame.domain;

public class Point {
    private Direction direction;

    private Point(Direction direction) {
        this.direction = direction;
    }

    public static Point pointFirst(boolean hasRight) {
        if (hasRight) {
            return new Point(Direction.RIGHT);
        }
        return new Point(Direction.STOP);
    }

    public Point nextPointLast() {
        if (direction == Direction.RIGHT) {
            return new Point(Direction.LEFT);
        }
        return new Point(Direction.STOP);
    }

    public Point nextPoint(boolean nextRight) {
        if (direction == Direction.RIGHT) {
            return new Point(Direction.LEFT);
        }
        if (nextRight) {
            return new Point(Direction.RIGHT);
        }
        return new Point(Direction.STOP);
    }

    public boolean isHasRight() {
        return direction == Direction.RIGHT;
    }

    public int move() {
        return direction.getDistance();
    }
}
