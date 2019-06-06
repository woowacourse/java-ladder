package ladderGame.model.ladder;

public class Point {
    private Direction direction;

    Point(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
