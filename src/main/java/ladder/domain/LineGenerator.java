package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    private final DirectionGenerator directionGenerator;

    public LineGenerator(DirectionGenerator directionGenerator) {
        this.directionGenerator = directionGenerator;
    }

    public Line generate(int width) {
        List<Direction> directions = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            if (i == 0) {
                directions.add(directionGenerator.generateInitialValue());
            }
            if (i != 0) {
                Direction priorDirection = directions.get(i - 1);
                directions.add(directionGenerator.generateValue(priorDirection));
            }
        }
        return new Line(directions);
    }
}
