package domain.generator;

import domain.Bridge;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public Bridge generate(Bridge bridge) {
        if (bridge.isNotExist() && RANDOM.nextBoolean()) {
            return Bridge.EXIST;
        }
        return Bridge.BLANK;
    }
}
