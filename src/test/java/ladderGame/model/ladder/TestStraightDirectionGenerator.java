package ladderGame.model.ladder;

import ladderGame.model.ladder.direction.Direction;
import ladderGame.model.ladder.direction.DirectionGenerator;

public class TestStraightDirectionGenerator implements DirectionGenerator {
    @Override
    public Direction generateDirection() {
        return Direction.STRAIGHT;
    }
}
