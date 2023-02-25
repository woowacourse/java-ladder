package domain;

import java.security.SecureRandom;

public class RandomBooleanGenerator implements BooleanGenerator {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public boolean generate() {
        return SECURE_RANDOM.nextBoolean();
    }
}
