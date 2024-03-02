package domain.strategy;

import domain.ladder.Bridge;

import java.util.Random;

public class RandomBridgeMakingStrategy extends BridgeMakingStrategy {
    private static final Random RANDOM_GENERATOR = new Random();

    @Override
    public Bridge getFirst() {
        return makeBridge();
    }

    @Override
    protected Bridge makeBridge() {
        return Bridge.of(RANDOM_GENERATOR.nextBoolean());
    }
}
