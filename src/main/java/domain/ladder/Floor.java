package domain.ladder;

import common.exception.model.ValidationException;

import java.util.List;

public class Floor {
    public static final String CONTINUOUS_BRIDGE_ERROR_MESSAGE = "한 층 내에서 사다리의 다리는 연속될 수 없습니다";

    private final List<LadderBridge> bridges;

    public Floor(final List<LadderBridge> bridges) {
        validateBridgesNotExistSerially(bridges);
        this.bridges = List.copyOf(bridges);
    }

    private void validateBridgesNotExistSerially(final List<LadderBridge> bridges) {
        for (int i = 1; i < bridges.size(); i++) {
            LadderBridge before = bridges.get(i - 1);
            compareBridgeStatus(before, bridges.get(i));
        }
    }

    private void compareBridgeStatus(final LadderBridge before, final LadderBridge now) {
        if (now.equals(before) && now.equals(LadderBridge.BRIDGE)) {
            throw new ValidationException(CONTINUOUS_BRIDGE_ERROR_MESSAGE);
        }
    }

    public BridgeDirection getBridgeAroundAt(final int playerPosition) {
        if (hasLeftBridge(playerPosition)) {
            return BridgeDirection.LEFT;
        } else if (hasRightBridge(playerPosition)) {
            return BridgeDirection.RIGHT;
        }
        return BridgeDirection.NONE;
    }

    private boolean hasLeftBridge(final int playerPosition) {
        return !isFirstPosition(playerPosition) && hasBridgeAt(playerPosition - 1);
    }

    private boolean isFirstPosition(final int playerPosition) {
        return playerPosition == 0;
    }

    private boolean hasRightBridge(final int playerPosition) {
        return !isLastPosition(playerPosition) && hasBridgeAt(playerPosition);
    }

    private boolean isLastPosition(int playerPosition) {
        return playerPosition == bridges.size();
    }

    private boolean hasBridgeAt(int bridgeIndex) {
        return bridges.get(bridgeIndex).equals(LadderBridge.BRIDGE);
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
