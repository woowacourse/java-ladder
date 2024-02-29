package domain.ladder;

import java.util.Collections;
import java.util.List;

public class Floor {

    private final List<Bridge> bridges;

    public Floor(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public int calculateResultPosition(final int startPosition) {
        final int leftBridgeIndex = startPosition - 1;
        if (leftBridgeIndex >= 0 && bridges.get(leftBridgeIndex) == Bridge.BRIDGE) {
            return startPosition - 1;
        }

        if (startPosition < bridges.size() && bridges.get(startPosition) == Bridge.BRIDGE) {
            return startPosition + 1;
        }

        return startPosition;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
