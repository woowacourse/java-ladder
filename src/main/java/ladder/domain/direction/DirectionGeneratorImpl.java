package ladder.domain.direction;

import java.util.Random;

public class DirectionGeneratorImpl implements DirectionGenerator {

    private final Random random;

    public DirectionGeneratorImpl() {
        this.random = new Random();
    }

    @Override
    public Direction generateInitialValue() {
        return generateRightOrNeutral();
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

    private Direction generateRightOrNeutral() {
        int randomNumber = random.nextInt(2);
        return Direction.getDirection(randomNumber);
    }
}
