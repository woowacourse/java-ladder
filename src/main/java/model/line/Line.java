package model.line;

import java.util.ArrayList;
import java.util.List;
import model.bridge.Bridge;

public class Line {

    private static final int LAST_BRIDGE_OFFSET = 1;
    private static final int LEFT_OFFSET = 1;

    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        this.bridges = List.copyOf(bridges);
    }

    public static Line of(List<Bridge> bridgesSource) {
        List<Bridge> discontinuousBridges = generateDiscontinuousBridges(bridgesSource);
        return new Line(discontinuousBridges);
    }

    private static List<Bridge> generateDiscontinuousBridges(List<Bridge> bridgesSource) {
        List<Bridge> discontinuousBridges = new ArrayList<>();
        for (Bridge bridgeSource : bridgesSource) {
            Bridge bridge = chooseBridge(bridgeSource, discontinuousBridges);
            discontinuousBridges.add(bridge);
        }
        return discontinuousBridges;
    }

    private static Bridge chooseBridge(Bridge bridge, List<Bridge> discontinuousBridges) {
        if (discontinuousBridges.isEmpty() || getLastBridge(discontinuousBridges).isUnconnected()) {
            return bridge;
        }
        return Bridge.UNCONNECTED;
    }

    private static Bridge getLastBridge(List<Bridge> bridges) {
        return bridges.get(bridges.size() - LAST_BRIDGE_OFFSET);
    }

    public int cross(int previousPosition) {
        int nextPosition = crossRightBridge(previousPosition);
        if (previousPosition == nextPosition) {
            nextPosition = crossLeftBridge(previousPosition);
        }
        return nextPosition;
    }

    private int crossRightBridge(int position) {
        if (canCrossRight(position)) {
            Bridge rightBridge = bridges.get(position);
            return rightBridge.moveRight(position);
        }
        return position;
    }

    private boolean canCrossRight(int position) {
        return position < bridges.size();
    }

    private int crossLeftBridge(int position) {
        if (canCrossLeft(position)) {
            Bridge leftBridge = bridges.get(position - LEFT_OFFSET);
            return leftBridge.moveLeft(position);
        }
        return position;
    }

    private boolean canCrossLeft(int position) {
        return position > 0;
    }

    public int size() {
        return bridges.size();
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
