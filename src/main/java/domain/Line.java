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
        buildBridge(bridgeGenerator, personCount, bridges);
        return new Line(bridges);
    }

    private static void buildBridge(final BridgeGenerator bridgeGenerator, final int personCount, final List<Bridge> bridges) {
        int bridgeCount = personCount - 1;
        while (bridges.size() < bridgeCount) {
            final Bridge bridgeCandidate = bridgeGenerator.generate();
            final Bridge previousBridge = findPreviousBridge(bridges);

            bridges.add(createBridge(bridgeCandidate, previousBridge));
        }
    }

    private static Bridge findPreviousBridge(List<Bridge> bridges) {
        if (bridges.size() == 0) {
            return Bridge.NO_BRIDGE;
        }
        return bridges.get(bridges.size() - 1);
    }

    private static Bridge createBridge(final Bridge bridgeCandidate, final Bridge previousBridge) {
        if (bridgeCandidate == Bridge.NO_BRIDGE) {
            return bridgeCandidate;
        }
        if (previousBridge == Bridge.NO_BRIDGE) {
            return bridgeCandidate;
        }
        return Bridge.NO_BRIDGE;
    }


    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
