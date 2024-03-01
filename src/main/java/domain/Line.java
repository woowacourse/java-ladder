package domain;

import domain.generator.BridgeGenerator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Line {

    private final Map<Integer, Bridge> bridges = new HashMap<>();

    public Line(int playersCount, BridgeGenerator bridgeGenerator) {
        for (int index = 0; index < playersCount - 1; index++) {
            Bridge previous = bridges.getOrDefault(index, Bridge.BLANK);
            Bridge generatedBridge = bridgeGenerator.generate(previous);
            bridges.put(index, generatedBridge);
        }
    }

    public Map<Integer, Bridge> getBridges() {
        return Collections.unmodifiableMap(bridges);
    }
}
