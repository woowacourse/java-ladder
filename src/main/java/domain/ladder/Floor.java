package domain.ladder;

import java.util.Collections;
import java.util.List;

public class Floor {

    private static final int MIN_BRIDGE_INDEX = 0;

    private final List<Bridge> bridges;

    public Floor(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public int calculateResultPosition(final int startPosition) {
        final int leftBridgeIndex = startPosition - 1;
        if (leftBridgeIndex >= MIN_BRIDGE_INDEX && bridges.get(leftBridgeIndex) == Bridge.EXIST) {
            return startPosition - 1;
        }
        final int rightBridgeIndex = startPosition;
        if (rightBridgeIndex < bridges.size() && bridges.get(rightBridgeIndex) == Bridge.EXIST) {
            return startPosition + 1;
        }

        return startPosition;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
