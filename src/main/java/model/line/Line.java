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
        Bridge preBridge = Bridge.UNCONNECTED;
        for (Bridge currentBridge : bridges) {
            checkBridge(preBridge, currentBridge);
            preBridge = currentBridge;
        }
    }

    private void checkBridge(Bridge preBridge, Bridge currentBridge) {
        if (preBridge.isConnected() && currentBridge.isConnected()) {
            throw new IllegalArgumentException(INVALID_BRIDGES);
        }
    }

    @Override
    public List<Bridge> bridges() {
        return Collections.unmodifiableList(bridges);
    }
}
