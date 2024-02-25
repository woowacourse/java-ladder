package ladder.domain.resource.direction;

public class DirectionLeftGeneratorImpl implements DirectionGenerator {

    @Override
    public Direction generateInitialValue() {
        return Direction.getDirection(2);
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
        int randomNumber = (int) (Math.random() * 2);
        return Direction.getDirection(randomNumber);
    }
}
