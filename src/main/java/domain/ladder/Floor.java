package domain.ladder;

import common.exception.model.ValidationException;

import java.util.List;

public class Floor {
    public static final String SERIAL_LADDER_BRIDGE = "한 층 내에서 사디리의 다리는 연속될 수 없습니다";
    private final List<LadderBridge> bridges;

    public Floor(List<LadderBridge> bridges) {
        validateBridgesNotExistSerially(bridges);
        this.bridges = List.copyOf(bridges);
    }

    private void validateBridgesNotExistSerially(List<LadderBridge> bridges) {
        for (int i = 1; i < bridges.size(); i++) {
            LadderBridge before = bridges.get(i - 1);
            compareBridgeStatus(before, bridges.get(i));
        }
    }

    private void compareBridgeStatus(LadderBridge before, LadderBridge now) {
        if (now.equals(before) && now.equals(LadderBridge.BRIDGE)) {
            throw new ValidationException(SERIAL_LADDER_BRIDGE);
        }
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }

    public BridgeDirection getBridgeAroundAt(int playerPosition) {
        if (hasLeftBridge(playerPosition)) {
            return BridgeDirection.LEFT;
        } else if (hasRightBridge(playerPosition)) {
            return BridgeDirection.RIGHT;
        }
        return BridgeDirection.NONE;
    }

    private boolean hasRightBridge(int playerPosition) {
        return !isLastPosition(playerPosition) && hasBridgeAt(playerPosition);
    }

    private boolean hasLeftBridge(int playerPosition) {
        return !isFirstPosition(playerPosition) && hasBridgeAt(playerPosition - 1);
    }

    private boolean hasBridgeAt(int bridgeIndex) {
        return bridges.get(bridgeIndex).equals(LadderBridge.BRIDGE);
    }

    private boolean isLastPosition(int playerPosition) {
        return playerPosition == bridges.size();
    }

    private boolean isFirstPosition(int playerPosition) {
        return playerPosition == 0;
    }
}
