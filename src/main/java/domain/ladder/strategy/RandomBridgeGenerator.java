package domain.ladder.strategy;

import domain.ladder.LadderBridge;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private final Random random = new Random();

    @Override
    public List<LadderBridge> generate(final int pointCount) {
        List<LadderBridge> bridges = new ArrayList<>(pointCount);
        for (int i = 0; i < pointCount; i++) {
            addPoint(i, bridges, LadderBridge.getByExist(random.nextBoolean()));
        }

        return bridges;
    }

    private void addPoint(final int index, final List<LadderBridge> points, final LadderBridge now) {
        if (index == 0) {
            points.add(now);
            return;
        }
        points.add(generateNoSerialBridge(points.get(index - 1)));
    }

    private LadderBridge generateNoSerialBridge(final LadderBridge before) {
        if (before.equals(LadderBridge.BRIDGE)) {
            return LadderBridge.NONE;
        }
        return LadderBridge.getByExist(random.nextBoolean());
    }
}
