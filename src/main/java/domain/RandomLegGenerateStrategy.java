package domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLegGenerateStrategy implements LegGenerateStrategy {
    @Override
    public boolean generateLeg() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
