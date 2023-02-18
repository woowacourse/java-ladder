package util;

import domain.Stool;

import java.security.SecureRandom;
import java.util.Random;

public class RandomStoolGenerator implements StoolGenerator {
    private final Random random = new SecureRandom();

    @Override
    public Stool next() {
        return Stool.of(random.nextBoolean());
    }
}
