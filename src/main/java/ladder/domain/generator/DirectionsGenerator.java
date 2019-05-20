package ladder.domain.generator;

import ladder.domain.Direction;

import java.util.List;

@FunctionalInterface
public interface DirectionsGenerator {
    List<Direction> generate();
}
