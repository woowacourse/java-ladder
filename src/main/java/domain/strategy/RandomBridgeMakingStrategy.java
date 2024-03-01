package domain.strategy;

import domain.ladder.Bridge;

import java.util.Random;

public class RandomBridgeMakingStrategy extends BridgeMakingStrategy {
    private static final Random RANDOM_GENERATOR = new Random();

    @Override
    public Bridge get() {
        return makeBridge();
    }

    @Override
    public Bridge makeBridge() {
        return Bridge.getOne(RANDOM_GENERATOR.nextBoolean());
    }
}
