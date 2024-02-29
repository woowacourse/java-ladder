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

    public Direction getBridgeLocation(final int playerPosition) {
        if (isBridgeOnLeft(playerPosition)) {
            return Direction.LEFT;
        }
        if (isBridgeOnRight(playerPosition)) {
            return Direction.RIGHT;
        }
        return Direction.UNDER;
    }

    private boolean isBridgeOnLeft(final int playerPosition) {
        return playerPosition != 0 && bridges.get(playerPosition - 1).isExist();
    }

    private boolean isBridgeOnRight(final int playerPosition) {
        return playerPosition != bridges.size() && bridges.get(playerPosition).isExist();
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
