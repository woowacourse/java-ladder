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


    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

}
