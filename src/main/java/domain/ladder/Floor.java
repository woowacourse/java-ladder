package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Floor {

    private final List<Bridge> bridges;

    private Floor(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Floor createByStrategy(final BridgeGenerator bridgeGenerator, final Width width) {
        List<Bridge> bridges = new ArrayList<>();

        while (bridges.size() < width.value()) {
            final Bridge bridgeCandidate = bridgeGenerator.generate();
            final Bridge previousBridge = findPreviousBridge(bridges);

            bridges.add(createBridge(bridgeCandidate, previousBridge));
        }
        return new Floor(bridges);
    }

    private static Bridge findPreviousBridge(List<Bridge> bridges) {
        if (bridges.isEmpty()) {
            return Bridge.NO_BRIDGE;
        }
        return bridges.get(bridges.size() - 1);
    }

    private static Bridge createBridge(final Bridge bridgeCandidate, final Bridge previousBridge) {
        if (previousBridge == Bridge.BRIDGE) {
            return Bridge.NO_BRIDGE;
        }
        return bridgeCandidate;
    }


    public int move(final int startPosition) {
        if (startPosition == 0) {
            if (bridges.get(startPosition) == Bridge.BRIDGE) {
                return startPosition + 1;
            }
            return startPosition;
        }
        if (startPosition == bridges.size()) {
            if (bridges.get(startPosition - 1) == Bridge.BRIDGE) {
                return startPosition - 1;
            }
            return startPosition;
        }
        if (bridges.get(startPosition - 1) == Bridge.BRIDGE) {
            return startPosition - 1;
        }
        if (bridges.get(startPosition) == Bridge.BRIDGE) {
            return startPosition + 1;
        }
        return startPosition;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
