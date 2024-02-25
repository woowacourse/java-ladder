package laddergame.util;

import laddergame.domain.Zone;

import java.util.Random;

public class RandomZoneGenerator implements ZoneGenerator {
    private static final RandomZoneGenerator generator = new RandomZoneGenerator();
    private final Random random;

    public RandomZoneGenerator() {
        this.random = new Random();
    }

    @Override
    public Zone generate() {
        if (random.nextInt(2) == 1) {
            return Zone.BRIDGE;
        }
        return Zone.EMPTY;
    }

    public static RandomZoneGenerator getGenerator() {
        return generator;
    }
}
