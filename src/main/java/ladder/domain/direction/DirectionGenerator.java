package ladder.domain.direction;

public interface DirectionGenerator {

    Direction generateInitialValue();

    Direction generateValue(Direction priorDirection);
}
