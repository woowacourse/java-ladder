package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class LineGenerator {

    private LineGenerator(){}

    public static Line build(final int targetWidth, final BooleanGenerator generator) {
        final List<Step> steps = new ArrayList<>();
        buildFirstStep(steps, generator);
        buildMiddleStep(steps, targetWidth, generator);
        buildLastStep(steps);
        return new Line(new ArrayList<>(steps));
    }

    private static void buildMiddleStep(final List<Step> steps, final int targetWidth, final BooleanGenerator generator) {
        for (int currentMiddleStep = 0; currentMiddleStep < targetWidth - 2; currentMiddleStep++) {
            addStep(steps, getValidConditionStep(generator.generate()));
        }
    }

    private static boolean isPreviousRightConnected(final List<Step> steps) {
        return (steps.get(steps.size() - 1) == Step.RIGHT);
    }

    private static void buildLastStep(final List<Step> steps) {
        addStep(steps, Step.NONE);
    }

    private static void addStep(final List<Step> steps, final Step step) {
        if (isPreviousRightConnected(steps)) {
            steps.add(Step.LEFT);
            return;
        }

        steps.add(step);
    }

    private static void buildFirstStep(final List<Step> steps, final BooleanGenerator generator) {
        steps.add(getValidConditionStep(generator.generate()));
    }

    private static Step getValidConditionStep(final boolean condition) {
        if (condition) {
            return Step.RIGHT;
        }
        return Step.NONE;
    }
}

