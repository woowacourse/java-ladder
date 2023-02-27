package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class LineGenerator {
    private final BooleanGenerator generator;

    private final List<Step> steps = new ArrayList<>();
    private int targetWidth;

    public LineGenerator(final BooleanGenerator generator) {
        this.generator = generator;
    }

    public Line build(final int targetWidth) {
        this.steps.clear();
        this.targetWidth = targetWidth;

        return buildLine();
    }

    private Line buildLine() {
        buildFirstStep();
        buildMiddleStep();
        buildLastStep();
        return new Line(new ArrayList<>(steps));
    }

    private void buildMiddleStep() {
        for (int currentMiddleStep = 0; currentMiddleStep < targetWidth - 2; currentMiddleStep++) {
            addStep(getValidConditionStep(generator.generate()));
        }
    }

    private boolean isPreviousRightConnected() {
        return (steps.get(steps.size() - 1) == Step.RIGHT);
    }

    private void buildLastStep() {
        addStep(Step.NONE);
    }

    private void addStep(final Step step) {
        if (isPreviousRightConnected()) {
            steps.add(Step.LEFT);
            return;
        }

        steps.add(step);
    }

    private void buildFirstStep() {
        steps.add(getValidConditionStep(generator.generate()));
    }

    private Step getValidConditionStep(final boolean condition) {
        if (condition) {
            return Step.RIGHT;
        }
        return Step.NONE;
    }
}

