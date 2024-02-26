package domain;

import java.util.Random;

public class RandomStepGenerator implements StepGenerator {

    private static final Random random = new Random();

    @Override
    public StepPoint generate() {
        if (random.nextBoolean()) {
            return StepPoint.PRESENT;
        }
        return StepPoint.ABSENT;
    }
}
