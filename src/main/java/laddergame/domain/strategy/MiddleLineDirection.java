package laddergame.domain.strategy;

import laddergame.domain.Direction;
import laddergame.domain.Rung;

public class MiddleLineDirection implements FindDirectionStrategy{
    @Override
    public Direction nextDirection(Rung leftRung, Rung rightRung) {
        if (leftRung.equals(Rung.BRIDGE)) {
            return Direction.LEFT;
        }
        if (rightRung.equals(Rung.BRIDGE)) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }
}
