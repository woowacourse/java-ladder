package ladder.domain.direction;

import ladder.domain.direction.Direction;
import ladder.domain.direction.DirectionGenerator;

public class DirectionNeutralGeneratorImpl implements DirectionGenerator {
    @Override
    public Direction generateInitialValue() {
        return Direction.getDirection(1);
    }

    @Override
    public Direction generateValue(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return generateRightOrNeutral();
    }

    private Direction generateRightOrNeutral() {
        int randomNumber = (int) (Math.random() * 2);
        return Direction.getDirection(randomNumber);
    }
}
