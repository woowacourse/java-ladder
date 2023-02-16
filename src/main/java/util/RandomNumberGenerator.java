package util;

import java.security.SecureRandom;

public class RandomNumberGenerator {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static int pickRandomNumberInRange(int lowerBoundInclusive, int upperBoundInclusive) {
        return SECURE_RANDOM.nextInt(upperBoundInclusive - lowerBoundInclusive + 1) + lowerBoundInclusive;
    }

}
