package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import model.Direction;
import utils.ThresholdChecker;

public class Line {

    private final List<Boolean> points;

    public Line(ThresholdChecker thresholdChecker, final int personCount) {
        points = new ArrayList<>(personCount);
        draw(thresholdChecker, personCount);
    }

    public List<Integer> findHorizontalPosition() {
        return IntStream.range(0, points.size())
                .sequential()
                .filter(points::get)
                .boxed()
                .toList();
    }

    void draw(ThresholdChecker generator, int personCount) {
        IntStream.range(0, personCount - 1)
                .forEach(position -> makeHorizontalLine(generator, position));

    }

    private void makeHorizontalLine(ThresholdChecker generator, int position) {
        points.add(false);
        if (isPassGenerateRuleByPosition(generator, position)) {
            points.set(position, true);
        }
    }

    private boolean isPassGenerateRuleByPosition(ThresholdChecker generator, int position) {
        return generator.isAboveThreshold() && !hasLeftConnectedLine(position);
    }

    private boolean hasLeftConnectedLine(int horizontalIndex) {
        if (horizontalIndex == 0) {
            return false;
        }
        return points.get(horizontalIndex - 1);
    }

    private boolean hasRightConnectedLine(int horizontalIndex) {
        if (horizontalIndex == points.size()) {
            return false;
        }
        return points.get(horizontalIndex);
    }

    public Direction findDirection(int horizontalIndex) {
        if (hasRightConnectedLine(horizontalIndex)) {
            return Direction.RIGHT;
        }
        if (hasLeftConnectedLine(horizontalIndex)) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }

}
