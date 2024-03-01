package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class FloorFactory {

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
            return Bridge.NOT_EXIST;
        }
        return bridges.get(bridges.size() - 1);
    }

    private static Bridge createBridge(final Bridge bridgeCandidate, final Bridge previousBridge) {
        if (previousBridge == Bridge.EXIST) {
            return Bridge.NOT_EXIST;
        }
        return bridgeCandidate;
    }
}
