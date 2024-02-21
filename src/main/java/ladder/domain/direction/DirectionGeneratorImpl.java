package ladder.domain.direction;

public class DirectionGeneratorImpl implements DirectionGenerator{

    @Override
    public Direction generateInitialValue() {
        return generateRightOrNeutral();
    }

    @Override
    public Direction generateValue(Direction priorDirection) {
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
