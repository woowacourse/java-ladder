package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final static int FIRST_LINE = 0;

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
        if (isContinuous(steps, index)) {
            throw new IllegalArgumentException("[ERROR] 라인에 Step이 연속될 수 없습니다.");
        }
    }

    private boolean isContinuous(List<Step> steps, int index) {
        return steps.get(index) == Step.EXIST && steps.get(index - 1) == Step.EXIST;
    }

    public int move(int position) {
        if (canMoveLeft(position)) {
            int leftPosition = position - 1;
            return leftPosition;
        }
        if (canMoveRight(position)) {
            int rightPosition = position + 1;
            return rightPosition;
        }
        return position;
    }

    private boolean canMoveLeft(int position) {
        int left = position - 1;
        return position != FIRST_LINE && steps.get(left) == Step.EXIST;
    }

    private boolean canMoveRight(int position) {
        int right = position;
        return position != steps.size() && steps.get(right) == Step.EXIST;
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    public int getSize() {
        return steps.size();
    }
}
