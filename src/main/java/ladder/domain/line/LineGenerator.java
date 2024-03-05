package ladder.domain.line;

import ladder.domain.direction.Direction;
import ladder.domain.direction.DirectionGenerator;

public class LineGenerator {

    private static final int LINE_BORDER = 2;

    private final DirectionGenerator directionGenerator;

    public LineGenerator(DirectionGenerator directionGenerator) {
        this.directionGenerator = directionGenerator;
    }

    public Line generate(int width) {
        Line line = new Line();
        addInitialDirection(line);

        int middleDirectionCount = width - LINE_BORDER;
        addMiddleDirection(middleDirectionCount, line);

        addLastDirection(line);

        return line;
    }

    private void addInitialDirection(Line line) {
        line.addDirection(directionGenerator.generateInitialDirection());
    }

    private void addMiddleDirection(int count, Line line) {
        for (int i = 0; i < count; i++) {
            Direction lastDirection = line.getLastDirection();
            line.addDirection(directionGenerator.generateMiddleDirection(lastDirection));
        }
    }

    private void addLastDirection(Line line) {
        Direction lastDirection = line.getLastDirection();
        line.addDirection(directionGenerator.generateLastDirection(lastDirection));
    }
}
