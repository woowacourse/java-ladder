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

    private void isSerialBridge(LadderBridge beforeBridge, LadderBridge nextBridge) {
        if (beforeBridge.equals(LadderBridge.BRIDGE) && beforeBridge == nextBridge) {
            throw new IllegalArgumentException(LadderExceptionMessage.SERIAL_LADDER_BRIDGE);
        }
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
