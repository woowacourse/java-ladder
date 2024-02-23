package model.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Step;

public class RandomBuildStrategy implements BuildStrategy<Step> {

    private static final Random random = new Random();

    @Override
    public List<Step> generate(int size) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            steps.add(generateStep(steps, i));
        }
        return steps;
    }

    private Step generateStep(List<Step> points, int index) {
        if (cannotConnect(points, index)) {
            return new Step(false);
        }
        return new Step(random.nextBoolean());
    }

    private boolean cannotConnect(List<Step> points, int index) {
        return index >= 1 && points.get(index - 1).hasStep();
    }
}
