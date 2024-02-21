package ladder.domain;

public interface DirectionGenerator {

    Direction generateInitialValue();

    Direction generateValue(Direction priorDirection);
}
