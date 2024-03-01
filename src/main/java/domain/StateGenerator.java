package domain;

import java.util.Random;

public class StateGenerator implements RandomGenerator {
    private final static Random RANDOM = new Random();

    @Override
    public PointState next() {
        final int randomNumber = RANDOM.nextInt(0, PointState.values().length);
        return PointState.findStateByCode(randomNumber);
    }
}
