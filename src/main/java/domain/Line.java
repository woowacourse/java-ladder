package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.BooleanGenerator;

public class Line {
    private final List<Boolean> bridges;

    private Line(int personCount) {
        this.bridges = new ArrayList<>();
        initializeEmptyLine(personCount);
    }

    public static Line generateWithBridges(BooleanGenerator booleanGenerator, int personCount) {
        Line line = new Line(personCount);
        line.generate(booleanGenerator);
        return line;
    }

    private void initializeEmptyLine(int personCount) {
        for (int index = 0; index < personCount - 1; index++) {
            bridges.add(false);
        }
    }

    private void generate(BooleanGenerator booleanGenerator) {
        for (int bridgeIndex = 0; bridgeIndex < bridges.size(); bridgeIndex++) {
            generateBridge(booleanGenerator, bridgeIndex);
        }
    }

    private void generateBridge(BooleanGenerator booleanGenerator, int bridgeIndex) {
        if (!hasSide(bridgeIndex, bridges.size() - 1)) {
            bridges.set(bridgeIndex, booleanGenerator.generate());
        }
    }

    private boolean hasSide(int bridgeIndex, int maxIndex) {
        if (bridgeIndex == 0 && maxIndex == 0) {
            return false;
        }

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
