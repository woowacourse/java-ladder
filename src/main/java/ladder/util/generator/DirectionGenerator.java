package ladder.util.generator;

import ladder.domain.Direction;

@FunctionalInterface
public interface DirectionGenerator {

    Direction generate();
}
