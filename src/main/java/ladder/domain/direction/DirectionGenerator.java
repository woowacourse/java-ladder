package ladder.domain.direction;

public interface DirectionGenerator {

    Direction generateInitialDirection();

    Direction generateMiddleDirection(Direction priorDirection);

    Direction generateLastDirection(Direction priorDirection);
}
