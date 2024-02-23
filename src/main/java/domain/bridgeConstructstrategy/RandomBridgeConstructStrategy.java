package domain.bridgeConstructstrategy;

import domain.BridgeStatus;
import domain.Bridges;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBridgeConstructStrategy implements BridgeConstructStrategy {

    private static final List<BridgeStatus> BRIDGE_STATUSES = Arrays.stream(BridgeStatus.values()).toList();

    @Override
    public Bridges generate(int count) {
        List<BridgeStatus> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) { // TODO 변수 네이 2

            addToBridge(result, random, i);
        }
        return new Bridges(result);
    }

    private void addToBridge(List<BridgeStatus> result, Random random, int i) {
        if (hasPreviousBridge(result, i)) {
            result.add(BridgeStatus.EMPTY);
            return;
        }
        int nextInt = random.nextInt(2);
        BridgeStatus randomBridgeStatus = BRIDGE_STATUSES.get(nextInt);
        result.add(randomBridgeStatus);
    }

    private boolean hasPreviousBridge(List<BridgeStatus> result, int i) {
        return i != 0 && result.get(i - 1) == BridgeStatus.BUILT;
    }
}
