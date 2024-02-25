package domain;

import java.util.Random;

public class RandomStepGenerator implements StepGenerator {
    @Override
    public Step generate() {
        Random random = new Random();
        return Step.from(random.nextBoolean());
    }
}
