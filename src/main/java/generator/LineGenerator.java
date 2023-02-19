package generator;

import java.util.ArrayList;
import java.util.List;

import domain.Bridge;
import domain.Line;

public class LineGenerator {

    private final BridgeGenerator bridgeGenerator;

    public LineGenerator(BridgeGenerator bridgeGenerator) {
        this.bridgeGenerator = bridgeGenerator;
    }

    public Line generate(final int personCount) {
        List<Bridge> newBridges = new ArrayList<>();
        Bridge lastBridge = Bridge.EMPTY;
        for (int i = 0; i < personCount - 1; i++) {
            Bridge nextBridge = getNextBridgeAfter(lastBridge);
            newBridges.add(nextBridge);
            lastBridge = nextBridge;
        }
        return new Line(newBridges);
    }

    private Bridge getNextBridgeAfter(final Bridge lastBridge) {
        if (lastBridge.doesExist()) {
            return Bridge.EMPTY;
        }
        return bridgeGenerator.generate();
    }
}
