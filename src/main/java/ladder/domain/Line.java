package ladder.domain;

import static ladder.domain.Direction.*;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Step> steps;

    public Line(List<Step> steps) {
        validateContinuousStep(steps);
        this.steps = steps;
    }

    private void validateContinuousStep(List<Step> steps) {
        for (int index = 1; index < steps.size(); index++) {
            checkContinuous(steps, index);
        }
    }

    private void checkContinuous(List<Step> steps, int index) {
        if (isContinuous(steps.get(index - 1), steps.get(index))) {
            throw new IllegalArgumentException("[ERROR] 라인에 Step이 연속될 수 없습니다.");
        }
    }

    private boolean isContinuous(Step leftStep, Step rightStep) {
        return leftStep == Step.EXIST && rightStep == Step.EXIST;
    }

    public int nextLineIndex(int index) {
        if (isLeftStepExist(index)) {
            return LEFT.move(index);
        }
        if (isRightStepExist(index)) {
            return RIGHT.move(index);
        }
        return STRAIGHT.move(index);
    }

    private boolean isLeftStepExist(int index) {
        if (index <= 0) {
            return false;
        }
        return steps.get(index - 1) == Step.EXIST;
    }

    private boolean isRightStepExist(int index) {
        if (index >= steps.size()) {
            return false;
        }
        return steps.get(index) == Step.EXIST;
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    public int getWidth() {
        return steps.size() + 1;
    }
}
