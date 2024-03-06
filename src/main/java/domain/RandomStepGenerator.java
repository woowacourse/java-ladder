package domain;

import java.util.Arrays;
import java.util.Random;

public class RandomStepGenerator implements StepGenerator {

    private static final Random random = new Random();

    @Override
    public StepPoint generate() {
        return from(random.nextBoolean());
    }

    private static StepPoint from(boolean value) {
        return Arrays.stream(StepPoint.values())
                .filter(it -> it.isExist() == value)
                .findAny()
                .orElseThrow();
    }
}
