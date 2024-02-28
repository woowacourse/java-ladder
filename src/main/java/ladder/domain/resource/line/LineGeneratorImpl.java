package ladder.domain.resource.line;

import ladder.domain.resource.direction.Direction;

public class LineGeneratorImpl implements LineGenerator {

    @Override
    public Line generateLine() {
        return new Line();
    }

    @Override
    public void insertDirectionIntoLine(Line line, int count) {
        int lastIndex = count - 1;

        for (int i = 0; i < count; i++) {
            setDirection(i, lastIndex, line);
        }
    }

    private void setDirection(int currentIndex, int lastIndex, Line line) {
        boolean lineEmpty = line.isEmpty();

        if (lineEmpty) {
            line.addDirection(getInitialDirection());
        }

        if (!lineEmpty && currentIndex < lastIndex) {
            Direction priorDirection = line.getLastDirection();
            line.addDirection(getMiddleDirection(priorDirection));
        }

        if (!lineEmpty && currentIndex == lastIndex) {
            Direction priorDirection = line.getLastDirection();
            line.addDirection(getLastDirection(priorDirection));
        }

    }

    private Direction getInitialDirection() {
        return Direction.getRightOrNeutral();
    }

    private Direction getMiddleDirection(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }

        return Direction.getRightOrNeutral();
    }

    private Direction getLastDirection(Direction priorDirection) {
        if (priorDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }

        return Direction.NEUTRAL;
    }
}
