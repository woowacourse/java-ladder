package laddergame.domain.strategy;

import laddergame.domain.Direction;
import laddergame.domain.Rung;

public class LastLineDirection implements FindDirectionStrategy {
    @Override
    public Direction nextDirection(Rung leftRung, Rung rightRung) {
        if (leftRung.equals(Rung.BRIDGE)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }
}
