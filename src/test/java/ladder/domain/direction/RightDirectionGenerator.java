package ladder.domain.direction;

public class RightDirectionGenerator implements DirectionGenerator {

    @Override
    public Direction generateInitialDirection() {
        return Direction.getDirection(true);
    }

    @Override
    public Direction generateMiddleDirection(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.RIGHT;
    }

    @Override
    public Direction generateLastDirection(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.NEUTRAL;
    }
}
