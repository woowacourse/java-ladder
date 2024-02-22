package domain;

import java.util.ArrayList;
import java.util.List;

public class WoodWorkMachine {
    private final BooleanGenerator randomBooleanGenerator;
    private final PlayerCount playerCount;

    public WoodWorkMachine(final PlayerCount playerCount, final BooleanGenerator randomBooleanGenerator) {
        this.playerCount = playerCount;
        this.randomBooleanGenerator = randomBooleanGenerator;
    }

    public Line makeLine() {
        List<Point> points = new ArrayList<>();

        int index = 0;
        while (isInCountRange(playerCount, points.size())) {
            points.add(makePoint(index, points));
            index++;
        }

        return new Line(points);
    }

    private Point makePoint(int index, List<Point> points) {
        if (hasBeforeStep(index, points) || isLastPoint(index)) {
            return new Point(Step.EMPTY);
        }
        Step step = Step.from(randomBooleanGenerator.generate());
        return new Point(step);
    }

    private boolean hasBeforeStep(int index, List<Point> points) {
        if (isFirstPoint(index)) {
            return false;
        }
        return points.get(index - 1).isStepExist();
    }

    private boolean isLastPoint(int index) {
        return playerCount.isSameWith(index + 1);
    }

    private boolean isFirstPoint(int index) {
        return index == 0;
    }

    private boolean isInCountRange(PlayerCount playerCount, int buildCount) {
        return playerCount.isBiggerThan(buildCount);
    }
}
