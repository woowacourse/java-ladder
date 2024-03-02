package ladder.domain.resource.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ladder.domain.resource.direction.Direction;

public class RandomLineGenerator implements LineGenerator {

    private final Random random = new Random();

    @Override
    public Line generateLine(int numberOfDirection) {
        List<Direction> directionInfo = selectDirections(numberOfDirection);
        return new Line(directionInfo);
    }

    private List<Direction> selectDirections(int numberOfDirection) {
        List<Direction> directions = new ArrayList<>();
        int lastIndex = numberOfDirection - 1;

        for (int i = 0; i < numberOfDirection; i++) {
            addDirection(directions, i, lastIndex);
        }

        return directions;
    }

    private void addDirection(List<Direction> directions, int currentIndex, int lastIndex) {
        if (currentIndex == 0) {
            addInitialDirection(directions);
        }
        if (currentIndex > 0 && currentIndex < lastIndex) {
            addMiddleDirection(directions, currentIndex);
        }
        if (currentIndex == lastIndex) {
            addLastDirection(directions, currentIndex);
        }
    }

    private void addInitialDirection(List<Direction> directions) {
        directions.add(selectRandomRightOrNeural());
    }

    private void addMiddleDirection(List<Direction> directions, int currentIndex) {
        Direction priorDirection = directions.get(currentIndex - 1);
        if (priorDirection == Direction.RIGHT) {
            directions.add(Direction.LEFT);
        }
        directions.add(selectRandomRightOrNeural());
    }

    private void addLastDirection(List<Direction> directions, int currentIndex) {
        Direction priorDirection = directions.get(currentIndex - 1);
        if (priorDirection == Direction.RIGHT) {
            directions.add(Direction.LEFT);
        }
        directions.add(Direction.NEUTRAL);
    }

    private Direction selectRandomRightOrNeural() {
        Direction[] rightAndNeutral = {Direction.RIGHT, Direction.NEUTRAL};
        return rightAndNeutral[random.nextInt(rightAndNeutral.length)];
    }
}
