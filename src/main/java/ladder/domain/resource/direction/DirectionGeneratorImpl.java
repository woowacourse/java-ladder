package ladder.domain.resource.direction;

public class DirectionGeneratorImpl implements DirectionGenerator {

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
        return Direction.getRightOrNeutral();
    }
}
