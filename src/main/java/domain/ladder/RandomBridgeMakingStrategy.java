package domain.ladder;

import java.util.Random;

import static domain.ladder.Bridge.EMPTY;
import static domain.ladder.Bridge.EXIST;

public class RandomBridgeMakingStrategy implements BridgeMakingStrategy {
    private static final Random random = new Random();

    public Bridge getOne(final Bridge previous) {
        if (doesBridgeExistAtLast(previous)) {
            return EMPTY;
        }
        return getRandomBridge();
    }

    private boolean doesBridgeExistAtLast(final Bridge previous) {
        if (previous == null) {
            return false;
        }
        return EXIST == previous;
    }

    private Bridge getRandomBridge() {
        if (random.nextBoolean()) {
            return EXIST;
        }
        return EMPTY;
    }
}
