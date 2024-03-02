package domain.ladder;

import domain.ladder.message.LadderExceptionMessage;
import java.util.List;

public class Floor {
    private final List<LadderBridge> bridges;

    public Floor(final List<LadderBridge> bridges) {
        validateSerialBridge(bridges);
        this.bridges = List.copyOf(bridges);
    }

    private void validateSerialBridge(final List<LadderBridge> bridges) {
        LadderBridge beforeBridge = bridges.get(0);
        for (int next = 1; next < bridges.size(); next++) {
            LadderBridge nextBridge = bridges.get(next);
            isSerialBridge(beforeBridge, nextBridge);
            beforeBridge = nextBridge;
        }
    }

    private void isSerialBridge(final LadderBridge beforeBridge, final LadderBridge nextBridge) {
        if (beforeBridge.equals(LadderBridge.BRIDGE) && beforeBridge == nextBridge) {
            throw new IllegalArgumentException(LadderExceptionMessage.SERIAL_LADDER_BRIDGE);
        }
    }

    public int getBridgePosition(final int playerPosition) {
        if (isBridgeOnLeft(playerPosition)) {
            return Direction.LEFT.getValue();
        }
        if (isBridgeOnRight(playerPosition)) {
            return Direction.RIGHT.getValue();
        }
        return Direction.UNDER.getValue();
    }

    private boolean isBridgeOnLeft(final int playerPosition) {
        int bridgePosition = playerPosition - 1;
        return !isBridgeOutOfRangeLeft(playerPosition) && bridges.get(bridgePosition).isExist();
    }

    private boolean isBridgeOutOfRangeLeft(final int playerPosition) {
        return playerPosition == 0;
    }

    private boolean isBridgeOnRight(final int playerPosition) {
        return !isBridgeOutOfRangeRight(playerPosition) && bridges.get(playerPosition).isExist();
    }

    private boolean isBridgeOutOfRangeRight(final int playerPosition) {
        return playerPosition == bridges.size();
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
