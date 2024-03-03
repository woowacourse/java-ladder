package ladder.domain.direction;

import java.util.Random;

public class RightDirectionGenerator implements DirectionGenerator {

    private final Random random;

    public RightDirectionGenerator() {
        this.random = new Random();
    }

    private Direction generateRightOrNeutral() {
        return Direction.getDirection(random.nextBoolean());
    }

    @Override
    public Direction generateInitialDirection() {
        return Direction.getDirection(true);
    }

    @Override
    public Direction generateMiddleDirection(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return generateRightOrNeutral();
    }

    @Override
    public Direction generateLastDirection(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.NEUTRAL;
    }
}
