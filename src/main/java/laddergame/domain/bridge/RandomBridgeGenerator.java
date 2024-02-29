package laddergame.domain.bridge;

import java.util.Random;


public class RandomBridgeGenerator implements BridgeGenerator {

    private static final Random random = new Random();

    @Override
    public Bridge generate() {
        return Bridge.from(random.nextBoolean());
    }
}
