package ladderGame.model.ladder;

public class Point {
    private Direction direction;

    Point(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setLeft() {
        this.direction = Direction.LEFT;
    }

    public void setRight() {
        this.direction = Direction.RIGHT;
    }
}
