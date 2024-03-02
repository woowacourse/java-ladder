package model.line;

import java.util.Collections;
import java.util.List;
import model.bridge.Bridge;

public class Line {
    private static final int POSITION_SHIFT = 1;
    private static final String INVALID_BRIDGES = "겹치는 다리가 존재합니다.";

    private final List<Bridge> bridges;

    public Line(List<Bridge> bridges) {
        validateBridges(bridges);
        this.bridges = bridges;
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

    public int play(int currentPosition) {
        if (currentPosition > 0 && bridges.get(currentPosition - POSITION_SHIFT).isConnected()) {
            return currentPosition - POSITION_SHIFT;
        }
        if (currentPosition < bridges.size() && bridges.get(currentPosition).isConnected()) {
            return currentPosition + POSITION_SHIFT;
        }
        return currentPosition;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
