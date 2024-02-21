package model;

import java.util.List;

public class Line {
    private static final String INVALID_BRIDGES = "겹치는 다리가 존재합니다.";
    private final List<Bridge> bridges;

    public Line(List<Boolean> bridges) {
        validateBridges(bridges);
        this.bridges = bridges.stream()
                .map(Bridge::new)
                .toList();
    }

    private void validateBridges(List<Boolean> bridges) {
        Boolean preBridge = false;
        for (Boolean currentBridge : bridges) {
            checkBridge(preBridge, currentBridge);
            preBridge = currentBridge;
        }
    }

    private void checkBridge(Boolean preBridge, Boolean currentBridge) {
        if (preBridge && currentBridge) {
            throw new IllegalArgumentException(INVALID_BRIDGES);
        }
    }

    public List<Boolean> getBridges() {
        return bridges.stream()
                .map(Bridge::getIsConnected)
                .toList();
    }
}
