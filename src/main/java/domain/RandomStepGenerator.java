package domain;

import java.util.Random;

public class RandomStepGenerator implements StepGenerator {
    private final Random random = new Random();

    @Override
    public Step generate() {
        return Step.from(random.nextBoolean());
    }
}