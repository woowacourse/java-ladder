package domain;

import java.util.Random;

public class RandomPointGenerator implements RandomGenerator {

    private static final int DIGIT_SIZE = 2;
    private static final int POSSIBLE_POINT = 1;

    @Override
    public boolean generate() {
        Random random = new Random();

        if (isPossible(random)) {
            return LineState.MOVABLE_STATE.getState();
        }
        return LineState.UNMOVABLE_STATE.getState();
    }

    private static boolean isPossible(Random random) {
        return random.nextInt(DIGIT_SIZE) == POSSIBLE_POINT;
    }
}
