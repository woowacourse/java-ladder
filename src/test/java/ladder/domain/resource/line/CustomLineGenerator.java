package ladder.domain.resource.line;

import ladder.domain.resource.direction.Direction;

public class CustomLineGenerator implements LineGenerator {

    @Override
    public Line generateLine() {
        return new Line();
    }

    @Override
    public void insertDirectionIntoLine(Line line, int count) {
        line.addDirection(Direction.RIGHT);
        line.addDirection(Direction.LEFT);
        line.addDirection(Direction.NEUTRAL);
    }
}
