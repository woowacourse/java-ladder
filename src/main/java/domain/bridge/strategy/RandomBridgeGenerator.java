package domain.bridge.strategy;

import domain.LadderBridge;
import domain.bridge.BridgeGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private static final Random random = new Random();

    @Override
    public List<LadderBridge> generate(int bridgeCount) {
        List<LadderBridge> bridges = new ArrayList<>(bridgeCount);
        for (int i = 0; i < bridgeCount; i++) {
            addBridge(i, bridges, LadderBridge.getByExist(random.nextBoolean()));
        }

        return bridges;
    }

    private void addBridge(int index, List<LadderBridge> bridge, LadderBridge now) {
        if (index == 0) {
            bridge.add(now);
            return;
        }
        bridge.add(generate(bridge.get(index - 1)));
    }

    private LadderBridge generate(LadderBridge before) {
        if(before.equals(LadderBridge.BRIDGE)) {
            return LadderBridge.NONE;
        }
        return LadderBridge.getByExist(random.nextBoolean());
    }
}
