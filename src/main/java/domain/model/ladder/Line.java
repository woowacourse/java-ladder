package domain.model.ladder;

import utils.RuleGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(RuleGenerator ruleGenerator, final int personCount) {
        points = new ArrayList<>();
        makeLine(ruleGenerator, personCount);
    }

    private void makeLine(RuleGenerator generator, int personCount) {
        IntStream.range(0, personCount - 1)
                .forEach(position -> connectToRight(generator, position));
        points.add(false);
    }

    private void connectToRight(RuleGenerator generator, int position) {
        points.add(false);
        if (generator.generate()
                && !hasLeftConnectedLine(position)) {
            points.set(position, true);
        }
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
