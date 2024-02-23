package model.line;

import java.util.Collections;
import java.util.List;
import model.bridge.Bridge;

public final class Line {
    private static final String INVALID_BRIDGES = "겹치는 다리가 존재합니다.";
    private final List<Bridge> bridges;

    public Line(List<Bridge> bridges) {
        validateBridges(bridges);
        this.bridges = bridges;
    }

    private void validateBridges(List<Bridge> bridges) {
        Bridge previousBridge = Bridge.UNCONNECTED;
        for (Bridge currentBridge : bridges) {
            checkBridge(previousBridge, currentBridge);
            previousBridge = currentBridge;
        }
    }

    private void checkBridge(Bridge previousBridge, Bridge currentBridge) {
        if (previousBridge.isConnected() && currentBridge.isConnected()) {
            throw new IllegalArgumentException(INVALID_BRIDGES);
        }
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
