package domain.bridgeConstructstrategy;

import domain.Bridge;
import domain.Bridges;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBridgeConstructStrategy implements BridgeConstructStrategy {

    private static final List<Bridge> BRIDGE_STATUSES = Arrays.stream(Bridge.values()).toList();

    @Override
    public Bridges generate(int count) {
        List<Bridge> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) { // TODO 변수 네이 2

            addToBridge(result, random, i);
        }
        return new Bridges(result);
    }

    private void addToBridge(List<Bridge> result, Random random, int i) {
        if (hasPreviousBridge(result, i)) {
            result.add(Bridge.EMPTY);
            return;
        }
        int nextInt = random.nextInt(2);
        Bridge randomBridge = BRIDGE_STATUSES.get(nextInt);
        result.add(randomBridge);
    }

    private boolean hasPreviousBridge(List<Bridge> result, int i) {
        return i != 0 && result.get(i - 1) == Bridge.BUILT;
    }
}
