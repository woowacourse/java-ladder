package domain.model;

import utils.RuleGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(RuleGenerator ruleGenerator, final int personCount) {
        points = new ArrayList<>(personCount);
        makeLine(ruleGenerator, personCount);
    }

    private void makeLine(RuleGenerator generator, int personCount) {
        IntStream.range(0, personCount - 1)
                .forEach(position -> makeHorizontalLine(generator, position));
    }

    private void makeHorizontalLine(RuleGenerator generator, int position) {
        points.add(false);
        if (generator.generate()  && !hasLeftConnectedLine(position)) {
            points.set(position, true);
        }
    }

    public List<Integer> findRightConnectedPositions() {
        return IntStream.range(0, points.size())
                .sequential()
                .filter(points::get)
                .boxed()
                .toList();
    }

    private boolean hasLeftConnectedLine(int position) {
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
