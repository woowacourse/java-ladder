package ladder.domain.generator;

import ladder.domain.Direction;

import java.util.List;

@FunctionalInterface
public interface DirectionGenerator {
    List<Direction> generate();
}
