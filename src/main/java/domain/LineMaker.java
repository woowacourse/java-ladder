package domain;

import java.util.ArrayList;
import java.util.List;

public class LineMaker {
    private final StepGenerator randomStepGenerator;
    private final PlayerCount playerCount;

    public LineMaker(final PlayerCount playerCount, final StepGenerator randomStepGenerator) {
        this.playerCount = playerCount;
        this.randomStepGenerator = randomStepGenerator;
    }

    public Line makeLine() {
        List<Step> steps = new ArrayList<>();

        for (int index = 0; isInCountRange(playerCount, index); index++) {
            steps.add(makeStep(index, steps));
        }
        return new Line(steps);
    }

    private boolean isInCountRange(PlayerCount playerCount, int buildCount) {
        return playerCount.isBiggerThan(buildCount);
    }

    private Step makeStep(int index, List<Step> steps) {
        if (hasBeforeStep(index, steps) || isLastPoint(index)) {
            return Step.EMPTY;
        }
        return randomStepGenerator.generate();
    }

    private boolean hasBeforeStep(int index, List<Step> points) {
        if (isFirstPoint(index)) {
            return false;
        }
        return points.get(index - 1).isExist();
    }

    private boolean isLastPoint(int index) {
        return playerCount.isSameWith(index + 1);
    }

    private boolean isFirstPoint(int index) {
        return index == 0;
    }
}
