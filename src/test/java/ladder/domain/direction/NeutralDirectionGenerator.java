package ladder.domain.direction;

import java.util.Random;

public class NeutralDirectionGenerator implements DirectionGenerator {

    private final Random random;

    public NeutralDirectionGenerator() {
        this.random = new Random();
    }

    private Direction generateRightOrNeutral() {
        return Direction.getDirection(random.nextBoolean());
    }

    @Override
    public Direction generateInitialValue() {
        return Direction.getDirection(false);
    }

    @Override
    public Direction generateMiddleValue(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return generateRightOrNeutral();
    }

    @Override
    public Direction generateLastValue(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.NEUTRAL;
    }
}
