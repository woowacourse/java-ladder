package model;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private final List<Boolean> steps;

    public Layer(int numberOfParticipants) {
        List<Boolean> steps = new ArrayList<>();
        boolean previousStep = false;

        for (int i = 0; i < numberOfParticipants - 1; i++) {
            boolean generatedStep = StepGenerator.generateStep(previousStep);
            previousStep = generatedStep;
            steps.add(generatedStep);
        }
        this.steps = steps;
    }

    public List<Boolean> getSteps() {
        return steps;
    }

    public int getLayerSize() {
        return steps.size();
    }
}
