package generator;

import domain.Bridge;
import domain.BridgeStatus;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    private final BridgeGenerator bridgeGenerator;

    public LineGenerator(BridgeGenerator bridgeGenerator) {
        this.bridgeGenerator = bridgeGenerator;
    }

    private static boolean hasLeftBridge(final List<BridgeStatus> bridgeStatuses) {
        if (bridgeStatuses.isEmpty()) {
            return false;
        }
        return bridgeStatuses.get(bridgeStatuses.size() - 1) == BridgeStatus.EXIST;
    }

    public Bridge generate(final int personCount) {
        List<BridgeStatus> newBridgeStatuses = new ArrayList<>();

        for (int i = 0; i < personCount - 1; i++) {
            newBridgeStatuses.add(getNextBridge(newBridgeStatuses));
        }

        return new Bridge(newBridgeStatuses);
    }

    private BridgeStatus getNextBridge(final List<BridgeStatus> bridgeStatuses) {
        if (hasLeftBridge(bridgeStatuses)) {
            return BridgeStatus.EMPTY;
        }

        return bridgeGenerator.generate();
    }
}
