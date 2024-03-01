package domain;

import java.util.Random;

public class BridgeRandomGenerator implements BridgeGenerator {
    private final Random random = new Random();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
