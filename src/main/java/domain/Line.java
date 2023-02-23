package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.BridgeGenerator;

public class Line {
    private final List<Bridge> bridges;
    private final int lineSize;

    public Line(int personCount) {
        this.bridges = IntStream.range(0, personCount - 1)
                .mapToObj(it -> Bridge.EMPTY)
                .collect(Collectors.toList());
        this.lineSize = bridges.size();
    }

    public void generate(BridgeGenerator bridgeGenerator) {
        for (int bridgeIndex = 0; bridgeIndex < lineSize; bridgeIndex++) {
            generateBridge(bridgeGenerator, bridgeIndex);
        }
    }

    private void generateBridge(BridgeGenerator bridgeGenerator, int bridgeIndex) {
        Bridge bridge = bridgeGenerator.generate();
        if (!hasBridgeInLeftOrRight(bridgeIndex)) {
            bridges.set(bridgeIndex, bridge);
        }
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
        return bridges.get(position - 1).getStatus();
    }

    public Boolean hasBridgeInRight(int position) {
        if (position == lineSize) {
            return false;
        }
        return bridges.get(position).getStatus();
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
