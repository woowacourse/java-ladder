package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<LineStep> line;
    private final BooleanGenerator booleanGenerator;

    private Line(List<LineStep> line, BooleanGenerator booleanGenerator) {
        this.line = line;
        this.booleanGenerator = booleanGenerator;
    }

    public static Line of(int numberOfHorizontalSteps, BooleanGenerator booleanGenerator) {
        List<LineStep> line = new ArrayList<>();
        for (int horizontalStep = 0; horizontalStep < numberOfHorizontalSteps; horizontalStep++) {
            line.add(LineStep.NON_EXIST);
        }
        return new Line(line, booleanGenerator);
    }

    public void generateRandomLine() {
        makeFirstRandomStep();
        for (int stepIndex = 1; stepIndex < line.size(); stepIndex++) {
            makeNextRandomSteps(stepIndex);
        }
    }

    private void makeFirstRandomStep() {
        if (booleanGenerator.generate()) {
            line.set(0, LineStep.EXIST);
        }
    }

    private void makeNextRandomSteps(int stepIndex) {
        if (!isExistPrevStep(stepIndex) && booleanGenerator.generate()) {
            line.set(stepIndex, LineStep.EXIST);
        }
        if (isExistPrevStep(stepIndex)) {
            line.set(stepIndex, LineStep.NON_EXIST);
        }
    }

    private boolean isExistPrevStep(int stepIndex) {
        return this.line.get(stepIndex - 1).equals(LineStep.EXIST);
    }

    public List<LineStep> getLine() {
        return this.line;
    }
}
