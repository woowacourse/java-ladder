package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<StepPoint> stepPoints;

    private Line(List<StepPoint> stepPoints) {
        this.stepPoints = stepPoints;
    }

    public static Line of(StepPointGenerator stepPointGenerator, LineWidth width) {
        return new Line(generateStepPoints(stepPointGenerator, width.get()));
    }

    private static List<StepPoint> generateStepPoints(StepPointGenerator stepPointGenerator, int width) {
        List<StepPoint> stepPoints = new ArrayList<>();
        StepPoint previousPoint = StepPoint.NONE;

        for (int i = 0; i < width; i++) {
            StepPoint generatedPoint = stepPointGenerator.generate(previousPoint);
            validateStepPoint(previousPoint, generatedPoint);
            stepPoints.add(generatedPoint);
            previousPoint = generatedPoint;
        }
        return stepPoints;
    }

    private static void validateStepPoint(StepPoint previous, StepPoint toAdd) {
        if (previous.isContinuous(toAdd)) {
            throw new IllegalArgumentException("디딤대는 연속적으로 존재할 수 없습니다.");
        }
    }

    public int size() {
        return stepPoints.size();
    }

    public List<StepPoint> toUnmodifiableStepPoints() {
        return List.copyOf(stepPoints);
    }
}
