package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Step> steps = new ArrayList<>();
    private final BooleanGenerator generator;

    public Line(final BooleanGenerator generator) {
        this.generator = generator;
    }

    public void generateStep() {
        if (!isStartEdge()) {
            addFootStep(getPreviousFootStep().isRightConnection());
            return;
        }
        addFootStep(false);
    }

    private Step getPreviousFootStep() {
        return this.steps.get(this.steps.size() - 1);
    }

    private void addFootStep(final boolean isPreviousStepRightConnected) {
        if (isPreviousStepRightConnected) {
            this.steps.add(Step.LEFT);
            return;
        }
        this.steps.add(Step.getRandomValidStep(generator.generate()));
    }

    private boolean isStartEdge() {
        return this.steps.isEmpty();
    }

    public int getWidth() {
        if (this.steps.isEmpty()) {
            return 0;
        }

        return this.steps.size();
    }

    public List<Boolean> getRightConnectionCondition() {
        return List.copyOf(steps.stream()
                .map(Step::isRightConnection)
                .collect(Collectors.toList()));
    }
}
