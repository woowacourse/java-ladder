package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineMaker {
    private final BooleanGenerator randomBooleanGenerator;
    private final PlayerCount playerCount;

    public LineMaker(final PlayerCount playerCount, final BooleanGenerator randomBooleanGenerator) {
        this.playerCount = playerCount;
        this.randomBooleanGenerator = randomBooleanGenerator;
    }

    public Line makeLine() {
        List<Point> points = new ArrayList<>();

        for (int index = 0; isInCountRange(playerCount, index); index++) {
            points.add(makePoint(index, points));
        }
        return new Line(points);
    }

    private boolean isInCountRange(PlayerCount playerCount, int buildCount) {
        return playerCount.isBiggerThan(buildCount);
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
}
