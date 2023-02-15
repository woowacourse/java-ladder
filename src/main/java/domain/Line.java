package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.BooleanGenerator;

public class Line {
    private final List<Boolean> bridges;

    public Line(int personCount) {
        this.bridges = new ArrayList<>();
        for (int index = 0; index < personCount - 1; index++) {
            bridges.add(false);
        }
    }

    public void generateBridge(BooleanGenerator booleanGenerator) {
        for (int bridgeIndex = 0; bridgeIndex < bridges.size(); bridgeIndex++) {
            if (!hasSide(bridgeIndex, bridges.size() - 1)) {
                bridges.set(bridgeIndex, booleanGenerator.generate());
            }
        }
    }

    public boolean hasSide(int bridgeIndex, int maxIndex) {
        if (bridgeIndex == 0) {
            return isBridgeInRight(bridgeIndex + 1);
        }

        if (bridgeIndex == maxIndex) {
            return isBridgeInLeft(bridgeIndex - 1);
        }

        return isBridgeInLeft(bridgeIndex - 1) || isBridgeInRight(bridgeIndex + 1);
    }

    private boolean isBridgeInLeft(int leftIndex) {
        return bridges.get(leftIndex);
    }

    private boolean isBridgeInRight(int rightIndex) {
        return bridges.get(rightIndex);
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
