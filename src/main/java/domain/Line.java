package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.BooleanGenerator;

public class Line {
    private final List<Bridge> bridges;
    private final int lineSize;

    public Line(int personCount) {
        this.bridges = IntStream.range(0, personCount - 1)
                .mapToObj(it -> Bridge.EMPTY)
                .collect(Collectors.toList());
        this.lineSize = bridges.size();
    }

    public void generate(BooleanGenerator booleanGenerator) {
        for (int bridgeIndex = 0; bridgeIndex < lineSize; bridgeIndex++) {
            generateBridge(booleanGenerator, bridgeIndex);
        }
    }

    private void generateBridge(BooleanGenerator booleanGenerator, int bridgeIndex) {
        Bridge randomBridge = generateRandomBridge(booleanGenerator);
        if (!hasBridgeInLeftOrRight(bridgeIndex)) {
            bridges.set(bridgeIndex, randomBridge);
        }
    }

    public Bridge generateRandomBridge(BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            return Bridge.EXIST;
        }
        return Bridge.EMPTY;
    }

    private boolean hasBridgeInLeftOrRight(int bridgeIndex) {
        if (bridgeIndex == 0 && lineSize == 1) {
            return false;
        }
        return hasBridgeInLeft(bridgeIndex) || hasBridgeInRight(bridgeIndex);
    }

    public Boolean hasBridgeInLeft(int position) {
        if (position == 0) {
            return false;
        }
        return bridges.get(position - 1).isExist();
    }

    public Boolean hasBridgeInRight(int position) {
        if (position == lineSize) {
            return false;
        }
        return bridges.get(position).isExist();
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
