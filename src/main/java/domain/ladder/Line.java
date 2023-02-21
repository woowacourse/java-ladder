package domain.ladder;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private final List<Step> steps = new ArrayList<>();
    private final BooleanGenerator generator;
    private final Integer width;

    private Line(BooleanGenerator generator, Integer width) {
        this.generator = generator;
        this.width = width;
    }

    public static Line of(final BooleanGenerator generator) {
        return new Line(generator, 0);
    }

    public static Line of(final int width, final BooleanGenerator generator) {
        return new Line(generator, width);
    }

    public boolean isConnectedToRight(final int index) {
        return this.steps.get(index).isConnectedToRight();
    }

    public boolean isConnectedToLeft(int index) {
        return this.steps.get(index).isConnectedToLeft();
    }

    public void generateStep() {
        if (!isStartEdge()) {
            if (isLastStep()) {
                Step previous = getPreviousStep();
                if (previous.isConnectedToRight()) {
                    steps.add(Step.makeLeft());
                    return;
                }
                steps.add(Step.makeNone());
                return;
            }
            Step previous = getPreviousStep();
            addStep(previous.isConnectedToRight());
            return;
        }
        addStep(false);
    }

    private boolean isLastStep() {
        return this.width - 1 == this.steps.size();
    }

    private Step getPreviousStep() {
        return this.steps.get(this.steps.size() - 1);
    }

    private void addStep(final boolean isPreviousStepConnectedToRight) {
        if (isPreviousStepConnectedToRight) {
            this.steps.add(Step.makeLeft());
            return;
        }
        this.steps.add(Step.makeRandom(generator.generate()));
    }

    private boolean isStartEdge() {
        return this.steps.size() == 0;
    }

    public int getWidth() {
        return this.steps.size();
    }

    public List<Boolean> getValue(){
        return List.copyOf(steps.stream()
                .map(Step::isConnectedToRight)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object line) {
        if (this == line) return true;
        if (line == null || getClass() != line.getClass()) return false;
        Line anotherLine = (Line) line;
        return this.steps.equals(anotherLine.steps) && this.generator.equals(anotherLine.generator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps, generator);
    }

    @Override
    public String toString() {
        return "Line{" +
                "footSteps=" + steps +
                ", generator=" + generator +
                '}';
    }
}
