package domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLegGenerateStrategy implements LegGenerateStrategy {
    @Override
    public Leg generateLeg() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            return Leg.CONNECTED;

        }
        return Leg.UN_CONNECTED;
    }
}
