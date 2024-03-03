package domain;

import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {

    private static final RandomBridgeGenerator instance = new RandomBridgeGenerator();
    private static final Random RANDOM = new Random();

    private RandomBridgeGenerator() {
    }

    public static RandomBridgeGenerator getInstance() {
        return instance;
    }

    @Override
    public Bridge generate() {
        return Bridge.from(RANDOM.nextBoolean());
    }
}
