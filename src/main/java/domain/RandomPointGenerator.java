package domain;

import java.util.Random;

public class RandomPointGenerator implements RandomGenerator {

    private static final Random random = new Random();

    @Override
    public boolean generate() {
        if (random.nextBoolean()){
            return LineState.MOVABLE_STATE.getState();
        }
        return LineState.UNMOVABLE_STATE.getState();
    }
}
