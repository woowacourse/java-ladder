package domain.ladder.bridgeConstructstrategy;

import domain.ladder.Bridge;
import domain.ladder.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomLineConstructStrategy implements LineConstructStrategy {

    private static final List<Bridge> BRIDGE_STATUSES = Arrays.stream(Bridge.values()).toList();

    @Override
    public Line generate(int count) {
        List<Bridge> result = new ArrayList<>();
        Random random = new Random();
        for (int index = 0; index < count; index++) {
            addToBridge(result, random, index);
        }
        return new Line(result);
    }

    private void addToBridge(List<Bridge> result, Random random, int index) {
        if (hasPreviousBridge(result, index)) {
            result.add(Bridge.EMPTY);
            return;
        }
        int nextInt = random.nextInt(2);
        Bridge randomBridge = BRIDGE_STATUSES.get(nextInt);
        result.add(randomBridge);
    }

    private boolean hasPreviousBridge(List<Bridge> result, int index) {
        if (index == 0) {
            return false;
        }
        return result.get(index - 1) == Bridge.BUILT;
    }
}
