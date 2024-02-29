package model.ladder.generator;

import java.util.Random;
import model.ladder.StepStatus;

public class RandomStatusGenerator implements StepStatusGenerator {
    private static final Random random = new Random();

    @Override
    public StepStatus generate() {
        return StepStatus.from(random.nextBoolean());
    }
}
