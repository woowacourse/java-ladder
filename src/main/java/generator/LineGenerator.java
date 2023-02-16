package generator;

import domain.Bridge;
import domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    private final BridgeGenerator bridgeGenerator;

    public LineGenerator(BridgeGenerator bridgeGenerator) {
        this.bridgeGenerator = bridgeGenerator;
    }

    public Line generate(final int personCount) {
        List<Bridge> newBridges = new ArrayList<>();

        for (int i = 0; i < personCount - 1; i++) {
            newBridges.add(getNextBridge(newBridges));
        }

        return new Line(newBridges);
    }

    private Bridge getNextBridge(final List<Bridge> bridges) {
        if (hasLeftBridge(bridges)) {
            return Bridge.EMPTY;
        }

        return bridgeGenerator.generate();
    }

    private static boolean hasLeftBridge(final List<Bridge> bridges) {
        if (bridges.isEmpty()) {
            return false;
        }
        return bridges.get(bridges.size() - 1) == Bridge.EXIST;
    }
}
