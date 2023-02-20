package util;

import java.security.SecureRandom;

public class RandomNumberGenerator {

    private static final int INCLUSIVE_FLAG = 1;
    private final SecureRandom secureRandom;

    public RandomNumberGenerator(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
    }

    public int pickRandomNumberInRange(int lowerBoundInclusive, int upperBoundInclusive) {
        return secureRandom.nextInt(
                upperBoundInclusive - lowerBoundInclusive + INCLUSIVE_FLAG) + lowerBoundInclusive;
    }

}
