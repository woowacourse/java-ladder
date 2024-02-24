package model;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private final List<Step> steps;

    public Layer(int numberOfParticipants) {
        List<Step> steps = new ArrayList<>();
        boolean priorExistence = false;

        for (int i = 1; i < numberOfParticipants; i++) {
            boolean doesExist = StepExistenceGenerator.generate(priorExistence);
            priorExistence = doesExist;
            steps.add(Step.findByExistence(doesExist));
        }
        this.steps = steps;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public int getLayerSize() {
        return steps.size();
    }
}
