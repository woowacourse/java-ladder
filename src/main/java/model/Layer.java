package model;

import java.util.List;

public class Layer {
    private final List<Step> steps;

    public Layer(List<Step> steps) {
        this.steps = steps;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public int getLayerSize() {
        return steps.size();
    }
}
