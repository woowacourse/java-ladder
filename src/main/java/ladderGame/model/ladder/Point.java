package ladderGame.model.ladder;

public class Point {
    private boolean drawn;
    private Direction direction;

    Point(boolean drawn) {
        this.drawn = drawn;
        this.direction = Direction.STRAIGHT;
    }

    public void setTrue() {
        drawn = true;
    }

    public boolean isTrue() {
        return drawn == true;
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

    public boolean isNotStraight() {
        return this.direction != Direction.STRAIGHT;
    }
}
