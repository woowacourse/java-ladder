package model.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.bridge.Bridge;

public final class Line {
    private final List<Bridge> bridges;

    public Line(List<Bridge> bridgesSource) {
        List<Bridge> bridges = getBridges(bridgesSource);
        this.bridges = Collections.unmodifiableList(bridges);
    }

    private List<Bridge> getBridges(List<Bridge> bridgesSource) {
        List<Bridge> bridges = new ArrayList<>();
        for (Bridge bridgeSource : bridgesSource) {
            Bridge bridge = chooseBridge(bridgeSource, bridges);
            bridges.add(bridge);
        }
        return bridges;
    }

    private Bridge chooseBridge(Bridge bridge, List<Bridge> bridges) {
        if (bridges.isEmpty() || getLastBridge(bridges).isUnconnected()) {
            return bridge;
        }
        return Bridge.UNCONNECTED;
    }

    private Bridge getLastBridge(List<Bridge> bridges) {
        return bridges.get(bridges.size() - 1);
    }

    public Integer cross(int previousPosition) {
        int nextPostition = crossRightBridge(previousPosition);

        if (previousPosition == nextPostition) {
            nextPostition = crossLeftBridge(previousPosition);
        }
        return nextPostition;
    }

    private int crossRightBridge(int position) {
        if (position < bridges.size()) {
            Bridge rightBridge = bridges.get(position);
            return rightBridge.moveRight(position);
        }
        return position;
    }

    private int crossLeftBridge(int position) {
        if (position > 0) {
            Bridge leftBridge = bridges.get(position - 1);
            return leftBridge.moveLeft(position);
        }
        return position;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
