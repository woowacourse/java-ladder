package ladder.util.generator;

import java.util.List;
import ladder.domain.Direction;
import ladder.util.generator.DirectionGenerator;

public class TestDirectionGenerator implements DirectionGenerator {

    private final List<Direction> directions;

    public TestDirectionGenerator(final List<Direction> directions) {
        this.directions = directions;
    }

    @Override
    public Direction generate() {
        return directions.remove(0);
    }
}
