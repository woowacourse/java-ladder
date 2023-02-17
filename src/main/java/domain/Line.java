package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private final List<FootStep> footSteps = new ArrayList<>();
    private final BooleanGenerator generator;

    private Line(final BooleanGenerator generator) {
        this.generator = generator;
    }

    public static Line of(final BooleanGenerator generator) {
        return new Line(generator);
    }

    public boolean isSteppableAt(final int index) {
        return this.footSteps
                .get(index)
                .isSteppable();
    }

    public void generateFootStep() {
        if (!isStartEdge()) {
            FootStep previous = getPreviousFootStep();
            addFootStep(previous.isSteppable());
            return;
        }
        addFootStep(false);
    }

    private FootStep getPreviousFootStep() {
        return this.footSteps.get(this.footSteps.size() - 1);
    }

    private void addFootStep(final boolean isPreviousFootStepSteppable) {
        if (isPreviousFootStepSteppable) {
            this.footSteps.add(FootStep.of(false));
            return;
        }
        this.footSteps.add(FootStep.of(generator.generate()));
    }

    private boolean isStartEdge() {
        return this.footSteps.size() == 0;
    }

    public int getWidth() {
        return this.footSteps.size();
    }

    public List<Boolean> getValue(){
        return List.copyOf(footSteps.stream()
                .map(FootStep::isSteppable)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object line) {
        if (this == line) return true;
        if (line == null || getClass() != line.getClass()) return false;
        Line anotherLine = (Line) line;
        return this.footSteps.equals(anotherLine.footSteps) && this.generator.equals(anotherLine.generator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(footSteps, generator);
    }

    @Override
    public String toString() {
        return "Line{" +
                "footSteps=" + footSteps +
                ", generator=" + generator +
                '}';
    }
}
