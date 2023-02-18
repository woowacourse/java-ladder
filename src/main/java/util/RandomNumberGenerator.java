package util;

import java.security.SecureRandom;

public class RandomNumberGenerator {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final int INCLUSIVE_FLAG = 1;

    public static int pickRandomNumberInRange(int lowerBoundInclusive, int upperBoundInclusive) {
        return SECURE_RANDOM.nextInt(
                upperBoundInclusive - lowerBoundInclusive + INCLUSIVE_FLAG) + lowerBoundInclusive;
    }

}
