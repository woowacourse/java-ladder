package ladder.domain.linegenerator.impl;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Line;
import ladder.domain.linegenerator.LineGenerator;

import java.util.List;

public class CustomLineGenerator implements LineGenerator {

    private List<Direction> customDirections;

    public CustomLineGenerator(List<Direction> directions) {
        customDirections = directions;
    }

    @Override
    public Line generateLine() {
        return new Line(customDirections);
    }
}
