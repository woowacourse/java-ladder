package domain;

import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public Bridge generate() {
        if (RANDOM.nextBoolean()) {
            return Bridge.EXIST;
        }

        return Bridge.EMPTY;
    }
}
