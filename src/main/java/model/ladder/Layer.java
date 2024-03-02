package model.ladder;

import java.util.List;

public class Layer {
    private final List<Step> steps;

    public Layer(List<Step> steps) {
        this.steps = steps;
    }

    public int move(int startIndex) {
        if (canMoveLeft(startIndex)) {
            return startIndex - 1;
        }
        if (canMoveRight(startIndex)) {
            return startIndex + 1;
        }
        return startIndex;
    }

    private boolean canMoveLeft(int startIndex) {
        return startIndex != 0 && steps.get(startIndex - 1) == Step.EXIST;
    }

    private boolean canMoveRight(int startIndex) {
        return startIndex != steps.size() && steps.get(startIndex) == Step.EXIST;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
