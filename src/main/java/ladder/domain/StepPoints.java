package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StepPoints {

    private final List<StepPoint> stepPoints = new ArrayList<>();
    private final StepPointGenerator stepPointGenerator;

    public StepPoints(StepPointGenerator stepPointGenerator, int count) {
        this.stepPointGenerator = stepPointGenerator;
        initialize(count);
    }

    private void initialize(int count) {
        StepPoint previousPoint = StepPoint.NONE;

        for (int i = 0; i < count; i++) {
            StepPoint generatedPoint = stepPointGenerator.generate(previousPoint);
            validateStepPoint(previousPoint, generatedPoint);
            stepPoints.add(generatedPoint);
            previousPoint = generatedPoint;
        }
    }

    private void validateStepPoint(StepPoint previous, StepPoint toAdd) {
        if (previous.isContinuous(toAdd)) {
            throw new IllegalArgumentException("디딤대는 연속적으로 존재할 수 없습니다.");
        }
    }

    public List<StepPoint> toUnmodifiableStepPoints() {
        return Collections.unmodifiableList(stepPoints);
    }
}
