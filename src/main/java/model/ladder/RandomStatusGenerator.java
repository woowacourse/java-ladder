package model.ladder;

import java.util.Random;

public class RandomStatusGenerator implements StepStatusGenerator {
    private static final Random random = new Random();

    @Override
    public StepStatus generate() {
        return StepStatus.from(random.nextBoolean());
    }
}
