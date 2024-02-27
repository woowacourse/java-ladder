package domain.ladder;

import java.util.Random;

public class RandomBridgeMakingStrategy implements BridgeMakingStrategy {
    private static final Random random = new Random();

    public Bridge getOne(final Bridge previous) {
        if (doesBridgeExistAtLast(previous)) {
            return Bridge.EMPTY;
        }
        return getRandomBridge();
    }

    private boolean doesBridgeExistAtLast(final Bridge previous) {
        if (previous == null) {
            return false;
        }
        return previous.isExist();
    }

    private Bridge getRandomBridge() {
        return Bridge.getOne(random.nextBoolean());
    }
}
