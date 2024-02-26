package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<StepPoint> stepPoints;

    public Line(int numberOfCell, StepGenerator stepGenerator) {
        stepPoints = new ArrayList<>();
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

    private boolean isPreviousStepExist(int cellIndex) {
        return isStepExistAt(cellIndex - 1);
    }

    public boolean isStepExistAt(int cellIndex) {
        return stepPoints.get(cellIndex).isExist();
    }

    public List<StepPoint> getStepPoints() {
        return stepPoints;
    }

    public int findNextLocation(int presentLocation) {
        if (presentLocation > 0 && stepPoints.get(presentLocation - 1) == StepPoint.PRESENT) {
            return presentLocation - 1;
        }
        if (presentLocation < stepPoints.size() && stepPoints.get(presentLocation) == StepPoint.PRESENT) {
            return presentLocation + 1;
        }
        return presentLocation;
    }
}
