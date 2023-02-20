package util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomTrueOrFalseGenerator implements TrueOrFalseGenerator {
    private static final Random secureRandom = new SecureRandom();

    @Override
    public boolean generate() {
        return secureRandom.nextBoolean();
    }
}
