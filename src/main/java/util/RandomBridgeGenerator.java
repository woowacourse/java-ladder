package util;

import domain.Bridge;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private static final Random random = new Random();

    public RandomBridgeGenerator() {
    }

    @Override
    public Bridge generate() {
        if (random.nextBoolean()) {
            return Bridge.EXIST;
        }
        return Bridge.EMPTY;
    }
}
