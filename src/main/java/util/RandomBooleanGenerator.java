package util;

import java.security.SecureRandom;

public class RandomBooleanGenerator implements BooleanGenerator {
    private static final SecureRandom rand = new SecureRandom();

    @Override
    public boolean generate() {
        return rand.nextBoolean();
    }
}
