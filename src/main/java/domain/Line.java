package domain;

import java.util.ArrayList;
import java.util.List;
import utils.StepGenerator;

public class Line {

    private final List<StepPoint> stepPoints = new ArrayList<>();

    public Line(int numberOfCell, StepGenerator stepGenerator) {
        stepPoints.add(stepGenerator.generate());
        for (int cellIndex = 1; cellIndex < numberOfCell; cellIndex++) {
            stepPoints.add(makeOnePoint(cellIndex, stepGenerator));
        }
    }

    private StepPoint makeOnePoint(int cellIndex, StepGenerator stepGenerator) {
        if (isPreviousStepExist(cellIndex)) {
            return StepPoint.ABSENT;
        }
        return stepGenerator.generate();
    }

    private boolean isPreviousStepExist(int index) {
        return stepPoints.get(index - 1)
                .isExist();
    }

    public boolean isExistStep(int index) {
        return stepPoints.get(index)
                .isExist();
    }

    public List<StepPoint> getStepPoints() {
        return stepPoints;
    }
}
