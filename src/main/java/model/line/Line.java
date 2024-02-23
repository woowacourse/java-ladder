package model.line;

import java.util.Collections;
import java.util.List;
import model.bridge.Bridge;

public record Line(List<Bridge> bridges) {
    private static final String INVALID_BRIDGES = "겹치는 다리가 존재합니다.";

    public Line {
        validateBridges(bridges);
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

    @Override
    public List<Bridge> bridges() {
        return Collections.unmodifiableList(bridges);
    }
}
