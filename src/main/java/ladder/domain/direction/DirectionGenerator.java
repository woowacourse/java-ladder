package ladder.domain.direction;

public interface DirectionGenerator {

    Direction generateInitialValue();

    Direction generateMiddleValue(Direction priorDirection);

    Direction generateLastValue(Direction priorDirection);
}
