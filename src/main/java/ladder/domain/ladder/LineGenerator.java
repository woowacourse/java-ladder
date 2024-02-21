package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.direction.Direction;
import ladder.domain.direction.DirectionGenerator;

public class LineGenerator {

    private final DirectionGenerator directionGenerator;

    public LineGenerator(DirectionGenerator directionGenerator) {
        this.directionGenerator = directionGenerator;
    }

    public Line generate(int width) {
        List<Direction> directions = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            addDirection(i, directions);
        }
        return new Line(directions);
    }

    private void addDirection(int index, List<Direction> directions) {
        if (index == 0) {
            directions.add(directionGenerator.generateInitialValue());
        }

        if (index != 0) {
            Direction priorDirection = directions.get(index - 1);
            directions.add(directionGenerator.generateValue(priorDirection));
        }

//        if (index == directions.size() - 1) {
//            Direction priorDirection = directions.get(index - 1);
//            directions.add(directionGenerator.generateLastValue(priorDirection));
//        }
    }
}
