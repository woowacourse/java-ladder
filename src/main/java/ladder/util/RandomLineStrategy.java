package ladder.util;

import ladder.domain.Line;
import ladder.domain.Step;
import java.util.Random;
import java.util.Stack;

public class RandomLineStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public Line generate(int width) {
        Stack<Step> steps = new Stack<>();
        while (steps.size() < width - 1) {
            steps.add(makeProperStep(steps));
        }
        return new Line(steps);
    }

    private Step makeProperStep(Stack<Step> steps) {
        if (isProperSteps(steps)) {
            return createRandomStep();
        }
        return Step.EMPTY;
    }

    private boolean isProperSteps(Stack<Step> steps) {
        return steps.isEmpty() || steps.peek() == Step.EMPTY;
    }

    private Step createRandomStep() {
        if (random.nextBoolean()) {
            return Step.EXIST;
        }
        return Step.EMPTY;
    }
}
