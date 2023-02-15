package util;

import domain.Line;
import domain.Step;
import java.util.Random;
import java.util.Stack;

public class RandomLineStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public Line generate(int width) {
        Stack<Step> steps = new Stack<>();
        while (true) {
            if (steps.size() == width - 1) {
                break;
            }
            if (steps.isEmpty()) {
                steps.add(createRandomStep());
            }
            if (steps.peek() == Step.EXIST) {
                steps.add(Step.EMPTY);
                continue;
            }
            steps.add(createRandomStep());
        }
        return new Line(steps);
    }

    private Step createRandomStep() {
        int number = random.nextInt(1);
        if (number == 0) {
            return Step.EMPTY;
        }
        return Step.EXIST;
    }
}
