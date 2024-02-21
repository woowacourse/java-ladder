package model;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Boolean> steps;

    public Layer(int numberOfParticipants) {
        List<Boolean> setUp = new ArrayList<>();
        StepGenerator stepGenerator = new StepGenerator();
        boolean beforeValue = false;

        for (int i = 0; i < numberOfParticipants - 1; i++) {
            boolean findValue = stepGenerator.generateStep(beforeValue);
            beforeValue = findValue;
            setUp.add(findValue);
        }
        this.steps = setUp;
    }

    public List<Boolean> getSteps() {
        return steps;
    }

    public int getLayerSize() {
        return steps.size();
    }
}
