package domain;

import java.util.Random;

public class BridgeRandomGenerator implements BridgeGenerator {
    private final Random random = new Random();

    @Override
    public Bridge generate() {
        if (random.nextBoolean()) {
            return Bridge.EXIST;
        }
        return Bridge.NONE;
    }
}
