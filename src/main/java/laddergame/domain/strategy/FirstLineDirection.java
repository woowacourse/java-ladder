package laddergame.domain.strategy;

import laddergame.domain.Direction;
import laddergame.domain.Line;
import laddergame.domain.Rung;

public class FirstLineDirection implements FindDirectionStrategy {
    @Override
    public Direction nextDirection(Rung leftRung, Rung rightRung) {
        if (rightRung.equals(Rung.BRIDGE)) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }
}
