package domain.point.strategy;

import domain.LadderBridge;
import domain.point.BridgeGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBridgeGenerator implements BridgeGenerator {
    private static final Random random = new Random();

    @Override
    public List<LadderBridge> generate(int pointCount) {
        List<LadderBridge> bridges = new ArrayList<>(pointCount);
        for (int i = 0; i < pointCount; i++) {
            addPoint(i, bridges, LadderBridge.getByExist(random.nextBoolean()));
        }

        return bridges;
    }

    private void addPoint(int index, List<LadderBridge> points, LadderBridge now) {
        if (index == 0) {
            points.add(now);
            return;
        }
        points.add(generatePoint(now, points.get(index - 1)));
    }

    private LadderBridge generatePoint(LadderBridge now, LadderBridge before) {
        while (now.equals(LadderBridge.BRIDGE) && before.equals(LadderBridge.BRIDGE)) {
            now = LadderBridge.getByExist(random.nextBoolean());
        }

        return now;
    }


}
