package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Step> steps;

    public Line(final List<Step> steps) {
        this.steps = steps;
    }

    public static Line create(PlayerCount playerCount, StepGenerator randomBooleanGenerator) {
        return new Line(createSteps(playerCount, randomBooleanGenerator));
    }

    private static List<Step> createSteps(PlayerCount playerCount, StepGenerator randomBooleanGenerator) {
        List<Step> steps = new ArrayList<>();

        for (int buildCount = 0; playerCount.isBiggerThan(buildCount); buildCount++) {
            steps.add(createStep(steps, randomBooleanGenerator, playerCount));
        }
        return steps;
    }

    private static Step createStep(List<Step> steps, StepGenerator randomStepGenerator,
                                   PlayerCount playerCount) {
        if (hasBeforeStep(steps) || isLastStep(steps, playerCount)) {
            return Step.EMPTY;
        }
        return randomStepGenerator.generate();
    }

    private static boolean hasBeforeStep(List<Step> steps) {
        int index = steps.size();
        if (index == 0) {
            return false;
        }
        return steps.get(index - 1).isExist();
    }

    private static boolean isLastStep(List<Step> steps, PlayerCount playerCount) {
        return playerCount.isSameWith(steps.size() + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(steps, line.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }
}
