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

    public int findPositionAbleToMove(int leftBridge, int rightBridge, int prevPosition) {
        int movePosition = prevPosition;
        if (isBridgeInLeft(leftBridge)) {
            movePosition--;
        }
        if (isBridgeInRight(rightBridge)) {
            movePosition++;
        }
        return movePosition;
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
        if (!hasSide(bridgeIndex)) {
            bridges.set(bridgeIndex, booleanGenerator.generate());
        }
    }

    private boolean hasSide(int bridgeIndex) {
        return isBridgeInLeft(bridgeIndex - 1) || isBridgeInRight(bridgeIndex + 1);
    }

    private boolean isBridgeInLeft(int leftIndex) {
        if (leftIndex < 0) {
            return false;
        }
        return bridges.get(leftIndex);
    }

    private boolean isBridgeInRight(int rightIndex) {
        if (rightIndex > bridges.size() - 1) {
            return false;
        }
        return bridges.get(rightIndex);
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
