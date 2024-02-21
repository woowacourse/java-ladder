package ladder.domain;

public class DirectionRightGeneratorImpl implements DirectionGenerator{
    @Override
    public Direction generateInitialValue() {
        return Direction.getDirection(0);
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
