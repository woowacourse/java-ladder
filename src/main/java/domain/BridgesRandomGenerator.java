package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BridgesRandomGenerator implements BridgesGenerator {
    private final Random random = new Random();

    public Bridges generate(int width) {
        List<Boolean> bridges = new ArrayList<>();
        boolean previousBridge = false;
        for (int i = 0; i < width; i++) {
            previousBridge = bridges.add(nextBridge(previousBridge));
        }
        return new Bridges(bridges);
    }

    private Boolean nextBridge(boolean previousBridge) {
        if (previousBridge) {
            return false;
        }
        return random.nextBoolean();
    }
}
