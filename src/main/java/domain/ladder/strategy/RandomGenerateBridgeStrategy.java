package domain.ladder.strategy;

import util.RandomNumberGenerator;

public class RandomGenerateBridgeStrategy implements GenerateBridgeStrategy {

    private static final int RATE = 40;
    private static final int LOWER_BOUND_INCLUSIVE = 1;
    private static final int UPPER_BOUND_INCLUSIVE = 100;

    @Override
    public boolean isGeneratedBridge() {
        return RandomNumberGenerator.pickRandomNumberInRange(
                LOWER_BOUND_INCLUSIVE, UPPER_BOUND_INCLUSIVE) <= RATE;
    }

}
