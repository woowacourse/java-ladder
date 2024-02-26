package model;

import utils.ThresholdChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        if (generator.isAboveThreshold() && !hasLeftConnectedLine(position)) {
            points.set(position, true);
        }
    }

    public boolean hasLeftConnectedLine(int position) {
        if (position == 0) {
            return false;
        }
        return points.get(position - 1);
    }

    public Direction showDirection(int position) {
        if (points.get(position)) {
            return Direction.RIGHT;
        }
        if (position > 0 && points.get(position - 1)) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }

}
