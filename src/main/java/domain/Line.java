package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.BridgeGenerator;

public class Line {
    private final List<Bridge> bridges;

    public Line(int personCount) {
        this.bridges = IntStream.range(0,personCount - 1)
                .mapToObj(it->Bridge.EMPTY)
                .collect(Collectors.toList());
    }

    public void generate(BridgeGenerator bridgeGenerator) {
        for (int bridgeIndex = 0; bridgeIndex < bridges.size(); bridgeIndex++) {
            generateBridge(bridgeGenerator, bridgeIndex);
        }
    }

    private void generateBridge(BridgeGenerator bridgeGenerator, int bridgeIndex) {
        if (!hasSide(bridgeIndex, bridges.size() - 1)) {
            bridges.set(bridgeIndex, bridgeGenerator.generate());
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

    private Boolean isBridgeInLeft(int leftIndex) {
        return bridges.get(leftIndex).getStatus();
    }

    private Boolean isBridgeInRight(int rightIndex) {
        return bridges.get(rightIndex).getStatus();
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
