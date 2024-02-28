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
    public int move(int position) {
        if (moveRight(position)) {
            position += 1;
            return position;
        }
        this.steps = steps;
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
        return steps;
    }

    public int getLayerSize() {
        return steps.size();
    }
}
