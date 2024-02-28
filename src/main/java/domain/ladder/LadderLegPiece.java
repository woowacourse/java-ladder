package domain.ladder;

import domain.ladder.attribute.Direction;

public class LadderLegPiece {
    private final Direction direction;

    public LadderLegPiece(Direction direction) {
        this.direction = direction;
    }

    public boolean isRightDirection() {
        return direction.equals(Direction.RIGHT);
    }

    public Direction getDirection() {
        return direction;
    }
}
