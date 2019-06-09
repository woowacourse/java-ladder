package ladderGame.model.ladder;

import ladderGame.model.ladder.direction.Direction;

public class Point {
    private Direction direction;

    Point(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
