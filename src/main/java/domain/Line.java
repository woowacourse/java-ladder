package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private final List<Step> footSteps = new ArrayList<>();
    private final BooleanGenerator generator;

    public Line(final BooleanGenerator generator) {
        this.generator = generator;
    }

    public boolean isSteppableAt(final int index) {
        if(this.footSteps.isEmpty()){
            return false;
        }

        return this.footSteps
                .get(index)
                .isSteppable();
    }

    public void generateFootStep() {
        if (!isStartEdge()) {
            Step previous = getPreviousFootStep();
            addFootStep(previous.isSteppable());
            return;
        }
        addFootStep(false);
    }

    private Step getPreviousFootStep() {
        return this.footSteps.get(this.footSteps.size() - 1);
    }

    private void addFootStep(final boolean isPreviousFootStepSteppable) {
        if (isPreviousFootStepSteppable) {
            this.footSteps.add(new Step(false));
            return;
        }
        this.footSteps.add(new Step(generator.generate()));
    }

    private boolean isStartEdge() {
        return this.footSteps.isEmpty();
    }

    public int getWidth() {
        if(this.footSteps.isEmpty()){
            return 0;
        }

        return this.footSteps.size();
    }

    public List<Boolean> getValue(){
        return List.copyOf(footSteps.stream()
                .map(Step::isSteppable)
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
