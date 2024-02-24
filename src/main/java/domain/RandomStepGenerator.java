package domain;

import java.util.Random;

public class RandomStepGenerator {
    public Step generate() {
        Random random = new Random();
        return Step.from(random.nextBoolean());
    }
}
