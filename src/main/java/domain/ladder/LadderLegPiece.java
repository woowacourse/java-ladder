package domain.ladder;

import domain.ladder.common.Direction;

public class LadderLegPiece {
    private final Direction direction;

    public LadderLegPiece(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isRightDirection() {
        return direction.equals(Direction.RIGHT);
    }
}
