package ladder.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import ladder.domain.Line;
import ladder.domain.Step;
import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public Line generate(int width) {
        Deque<Step> steps = new ArrayDeque<>();
        while (steps.size() < width - 1) {
            steps.add(makeProperStep(steps));
        }
        return new Line(new ArrayList<>(steps));
    }

    private Step makeProperStep(Deque<Step> steps) {
        if (isProperSteps(steps)) {
            return createRandomStep();
        }
        return Step.EMPTY;
    }

    private boolean isProperSteps(Deque<Step> steps) {
        return steps.isEmpty() || steps.peekLast() == Step.EMPTY;
    }

    private Step createRandomStep() {
        if (random.nextBoolean()) {
            return Step.EXIST;
        }
        return Step.EMPTY;
    }
}
