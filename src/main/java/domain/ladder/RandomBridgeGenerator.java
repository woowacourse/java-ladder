package domain.ladder;

import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private final static RandomBridgeGenerator instance = new RandomBridgeGenerator();

    private RandomBridgeGenerator() {
    }

    public static RandomBridgeGenerator getInstance() {
        return instance;
    }

    @Override
    public Bridge generate() {
        final Random random = new Random();
        return Bridge.getBy(random.nextBoolean());
    }
}
