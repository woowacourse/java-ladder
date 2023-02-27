package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.BooleanGenerator;

public class Line {
    private static final int LEFTMOST_INDEX = 0;
    private final List<Bridge> bridges;

    public Line(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Line from(int personCount) {
        List<Bridge> bridges = IntStream.range(0, personCount - 1)
                .mapToObj(it -> Bridge.EMPTY)
                .collect(Collectors.toList());
        return new Line(bridges);
    }

    public void generate(BooleanGenerator booleanGenerator) {
        for (int bridgeIndex = 0; bridgeIndex < bridges.size(); bridgeIndex++) {
            generateBridge(booleanGenerator, bridgeIndex);
        }
    }

    private void generateBridge(BooleanGenerator booleanGenerator, int bridgeIndex) {
        Bridge randomBridge = generateRandomBridge(booleanGenerator);
        if (!hasBridgeInLeftOrRight(bridgeIndex)) {
            bridges.set(bridgeIndex, randomBridge);
        }
    }

    private Bridge generateRandomBridge(BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            return Bridge.EXIST;
        }
        return Bridge.EMPTY;
    }

    private boolean hasBridgeInLeftOrRight(int bridgeIndex) {
        if (bridgeIndex == LEFTMOST_INDEX && bridges.size() == 1) {
            return false;
        }
        return hasBridgeInLeft(bridgeIndex) || hasBridgeInRight(bridgeIndex);
    }

    public Boolean hasBridgeInLeft(int position) {
        if (position == LEFTMOST_INDEX) {
            return false;
        }
        return bridges.get(position - 1).isExist();
    }

    public Boolean hasBridgeInRight(int position) {
        if (position == bridges.size()) {
            return false;
        }
        return bridges.get(position).isExist();
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
