package domain;

import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private final static RandomBridgeGenerator instance = new RandomBridgeGenerator();

    private RandomBridgeGenerator() {
    }

    public static RandomBridgeGenerator getInstance() {
        return instance;
    }

    @Override
    public boolean generate() {
        final Random random = new Random();
        return random.nextBoolean();
    }
}
