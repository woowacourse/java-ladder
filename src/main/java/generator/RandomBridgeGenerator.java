package generator;

import domain.BridgeStatus;

import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public BridgeStatus generate() {
        if (RANDOM.nextBoolean()) {
            return BridgeStatus.EXIST;
        }

        return BridgeStatus.EMPTY;
    }
}
