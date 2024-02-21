package ladder.domain;

public class DirectionGeneratorImpl implements DirectionGenerator{

    @Override
    public Direction generateInitialValue() {
        int randomNumber =  (int) (Math.random() * 2);
        return Direction.getDirection(randomNumber);
    }

    @Override
    public Direction generateValue(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return generateInitialValue();
    }
}
