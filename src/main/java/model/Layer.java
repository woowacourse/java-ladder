package model;

import java.util.Collections;
import java.util.List;

public class Layer {
    private final List<Step> steps;

    public Layer(List<Step> steps) {
        this.steps = steps;
    }

    public int move(int position) {
        if (moveRight(position)) {
            position += 1;
            return position;
        }
        if (moveLeft(position)) {
            position -= 1;
        }
        return position;
    }

    private boolean moveRight(int position) {
        return position != steps.size() && steps.get(position) == Step.EXIST;
    }

    private boolean moveLeft(int position) {
        return position != 0 && steps.get(position - 1) == Step.EXIST;
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    public int getLayerSize() {
        return steps.size();
    }
}
