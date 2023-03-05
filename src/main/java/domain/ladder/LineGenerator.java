package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class LineGenerator {
    private final BooleanGenerator generator;

    public LineGenerator(final BooleanGenerator generator) {
        this.generator = generator;
    }

    public Line build(final int targetWidth) {
        final List<Step> steps = new ArrayList<>();
        buildFirstStep(steps);
        buildMiddleStep(steps, targetWidth);
        buildLastStep(steps);
        return new Line(new ArrayList<>(steps));
    }

    private void buildMiddleStep(final List<Step> steps, final int targetWidth) {
        for (int currentMiddleStep = 0; currentMiddleStep < targetWidth - 2; currentMiddleStep++) {
            addStep(steps, getValidConditionStep(generator.generate()));
        }
    }

    private boolean isPreviousRightConnected(final List<Step> steps) {
        return (steps.get(steps.size() - 1) == Step.RIGHT);
    }

    private void buildLastStep(final List<Step> steps) {
        addStep(steps, Step.NONE);
    }

    private void addStep(final List<Step> steps, final Step step) {
        if (isPreviousRightConnected(steps)) {
            steps.add(Step.LEFT);
            return;
        }

        steps.add(step);
    }

    private void buildFirstStep(final List<Step> steps) {
        steps.add(getValidConditionStep(generator.generate()));
    }

    private Step getValidConditionStep(final boolean condition) {
        if (condition) {
            return Step.RIGHT;
        }
        return Step.NONE;
    }
}

