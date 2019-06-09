package ladderGame.model.ladder;

import ladderGame.model.ladder.direction.Direction;
import ladderGame.model.ladder.direction.DirectionGenerator;

public class TestRightDirectionGenerator implements DirectionGenerator {
    @Override
    public Direction generateDirection() {
        return Direction.RIGHT;
    }
}
