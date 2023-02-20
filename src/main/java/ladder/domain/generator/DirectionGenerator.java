package ladder.domain.generator;

import ladder.domain.Direction;

@FunctionalInterface
public interface DirectionGenerator {

    Direction generate();
}
