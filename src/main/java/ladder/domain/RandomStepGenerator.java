package ladder.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStepGenerator implements StepGenerator {

    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    @Override
    public Step generate() {
        if (threadLocalRandom.nextBoolean()) {
            return Step.CONNECTED;
        }
        return Step.BLANK;
    }
}
