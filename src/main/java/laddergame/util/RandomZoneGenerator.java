package laddergame.util;

import laddergame.domain.Zone;

import java.util.Random;

public class RandomZoneGenerator implements ZoneGenerator {

    private final Random random;

    public RandomZoneGenerator() {
        this.random = new Random();
    }

    @Override
    public Zone generate() {
        return Zone.getZone(random.nextBoolean());
    }
}
