package domain.bridge.strategy;

import domain.bridge.BridgeGenerator;
import domain.ladder.LadderBridge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBridgeGenerator implements BridgeGenerator {

    @Override
    public List<LadderBridge> generate(final int bridgeCount) {
        List<LadderBridge> bridges = new ArrayList<>(bridgeCount);
        for (int i = 0; i < bridgeCount; i++) {
            addBridge(i, bridges);
        }

        return bridges;
    }

    private void addBridge(final int index, final List<LadderBridge> bridge) {
        if (index == 0) {
            bridge.add(getRandomBridge());
            return;
        }
        bridge.add(generateBridge(bridge.get(index - 1)));
    }

    private LadderBridge generateBridge(final LadderBridge before) {
        if(before.equals(LadderBridge.BRIDGE)) {
            return LadderBridge.NONE;
        }
        return getRandomBridge();
    }

    private LadderBridge getRandomBridge() {
        return LadderBridge.getByExist(ThreadLocalRandom.current().nextBoolean());
    }
}
