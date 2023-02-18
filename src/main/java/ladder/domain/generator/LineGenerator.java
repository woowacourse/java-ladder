package ladder.domain.generator;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Direction;
import ladder.domain.Line;

public class LineGenerator {

    private final DirectionGenerator directionGenerator;

    public LineGenerator(final DirectionGenerator directionGenerator) {
        this.directionGenerator = directionGenerator;
    }

    public Line generate(final int directionCount) {
        return new Line(generateDirections(directionCount));
    }

    private List<Direction> generateDirections(final int directionCount) {
        final List<Direction> directions = new ArrayList<>();
        generateDirectionsStrategy(directions, directionCount);
        return directions;
    }

    private void generateDirectionsStrategy(final List<Direction> directions, final int directionCount) {
        if (directions.size() >= directionCount - 1) {
            addStayIfNotEnough(directions, directionCount);
            return;
        }
        addDirections(directions);
        generateDirectionsStrategy(directions, directionCount);
    }

    private void addStayIfNotEnough(final List<Direction> directions, final int directionCount) {
        if (isNotEnough(directions, directionCount)) {
            directions.add(STAY);
        }
    }

    private boolean isNotEnough(final List<Direction> directions, final int directionCount) {
        return directions.size() == directionCount - 1;
    }

    private void addDirections(final List<Direction> directions) {
        final Direction direction = directionGenerator.generate();

        directions.add(direction);

        if (direction == RIGHT) {
            directions.add(LEFT);
        }
    }
}
