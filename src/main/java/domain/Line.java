package domain;

import java.util.ArrayList;
import java.util.List;
import utils.StepGenerator;

public class Line {

    public static final int ONE_STEP = 1;
    private final List<StepPoint> stepPoints = new ArrayList<>();

    public Line(int numberOfCell, StepGenerator stepGenerator) {
        stepPoints.add(stepGenerator.generate());
        for (int cellIndex = 1; cellIndex < numberOfCell; cellIndex++) {
            stepPoints.add(makeOnePoint(cellIndex, stepGenerator));
        }
    }

    public boolean isExistLeftStep(int nowStep) {
        if (nowStep == 0) {
            return false;
        }
        return isExistStep(nowStep - ONE_STEP);
    }

    private StepPoint makeOnePoint(int cellIndex, StepGenerator stepGenerator) {
        if (isPreviousStepExist(cellIndex)) {
            return StepPoint.ABSENT;
        }
        return stepGenerator.generate();
    }

    private boolean isPreviousStepExist(int cellIndex) {
        return isExistStep(cellIndex - 1);
    }

    public boolean isExistStep(int index) {
        return stepPoints.get(index)
                .isExist();
    }

    public List<StepPoint> getStepPoints() {
        return stepPoints;
    }
}
