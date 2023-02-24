package domain.ladder;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Line {

    public static final int BRIDGE_LENGTH = 5;
    private final List<Step> steps = new ArrayList<>();
    private final BooleanGenerator generator;
    private final Integer width;

    private Line(BooleanGenerator generator, Integer width) {
        this.generator = generator;
        this.width = width;
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

    public void generateSteps() {
        generateFirstStep();
        generateMiddleStep();
        generateLastStep();
    }

    private void generateFirstStep() {
        steps.add(Step.makeWithRightCondition(generator.generate()));
    }

    private void generateMiddleStep() {
        while (!isLastStep()) {
            generateStep();
        }
    }

    private void generateStep() {
        if (isPreviousConnected()) {
            steps.add(Step.LEFT);
            return;
        }
        steps.add(Step.makeWithRightCondition(generator.generate()));
    }

    private void generateLastStep() {
        if (isPreviousConnected()) {
            steps.add(Step.LEFT);
            return;
        }
        steps.add(Step.NONE);
    }

    public Iterator<Boolean> findConnectedConditions(){
        return steps.stream()
                .map(Step::isConnectedToRight)
                .iterator();
    }

    private boolean isPreviousConnected() {
        return getPreviousStep().isConnectedToRight();
    }

    private boolean isLastStep() {
        return this.width - 1 == this.steps.size();
    }

    private Step getPreviousStep() {
        return this.steps.get(this.steps.size() - 1);
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
