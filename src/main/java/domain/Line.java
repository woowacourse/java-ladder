package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Step> steps;

    public Line(List<Step> steps) {
        validateContinuousStep(steps);
        this.steps = steps;
    }

    public int getSize() {
        return steps.size();
    }

    private void validateContinuousStep(List<Step> steps) {
        for (int index = 1; index < steps.size(); index++) {
            checkContinuous(steps, index);
        }
    }

    private void checkContinuous(List<Step> steps, int index) {
        if (isContinuous(steps, index)) {
            throw new IllegalArgumentException("[ERROR] 라인에 Step이 연속될 수 없습니다.");
        }
    }

    private boolean isContinuous(List<Step> steps, int index) {
        return steps.get(index) == Step.EXIST && steps.get(index - 1) == Step.EXIST;
    }

    public String asString() {
        return "|" + steps.stream()
                .map(Step::getShape)
                .collect(Collectors.joining("|")) + "|";
    }
}
