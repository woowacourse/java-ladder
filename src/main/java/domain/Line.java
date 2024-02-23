package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Line createByStrategy(final BridgeGenerator bridgeGenerator, final int personCount) {
        List<Bridge> bridges = new ArrayList<>();
        while (bridges.size() < personCount - 1) {
            final Bridge bridgeCandidate = bridgeGenerator.generate();
            final Bridge previousBridge = findPreviousBridge(bridges);

            bridges.add(createBridge(bridgeCandidate, previousBridge));
        }
        return new Line(bridges);
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
