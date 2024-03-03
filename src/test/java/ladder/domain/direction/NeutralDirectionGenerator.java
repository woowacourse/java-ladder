package ladder.domain.direction;

public class NeutralDirectionGenerator implements DirectionGenerator {

    public NeutralDirectionGenerator() {
    }

    @Override
    public Direction generateInitialDirection() {
        return Direction.getDirection(false);
    }

    @Override
    public Direction generateMiddleDirection(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.NEUTRAL;
    }

    @Override
    public Direction generateLastDirection(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.NEUTRAL;
    }
}
