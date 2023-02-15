package domain;

import java.util.List;

public class Line {
    private final List<Step> steps;

    public Line(List<Step> steps) {
        validateContinuousStep(steps);
        this.steps = steps;
    }

    public int getSize() {
        return steps.size();
    }

    private static void validateContinuousStep(List<Step> steps) {
        for (int i = 1; i < steps.size(); i++) {
            if (steps.get(i - 1) == steps.get(i)) {
                throw new IllegalArgumentException("[ERROR] 라인에 Step이 연속될 수 없습니다.");
            }
        }
    }
}
