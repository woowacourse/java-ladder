package domain;

import domain.generator.BridgeGenerator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Line {

    private final Map<Integer, Bridge> bridges = new HashMap<>();

    public Line(int playersCount, BridgeGenerator bridgeGenerator) {
        for (int index = 0; index < playersCount - 1; index++) {
            Bridge previous = getBridgeIndexOf(index - 1);
            Bridge generatedBridge = bridgeGenerator.generate(previous);
            bridges.put(index, generatedBridge);
        }
    }

    public int calculatePosition(int playerIndex) {
        if (getBridgeIndexOf(playerIndex - 1).isExist()) {
            return playerIndex - 1;
        }
        if (getBridgeIndexOf(playerIndex).isExist()) {
            return playerIndex + 1;
        }
        return playerIndex;
    }

    private Bridge getBridgeIndexOf(int playerIndex) {
        return bridges.getOrDefault(playerIndex, Bridge.BLANK);
    }

    public Map<Integer, Bridge> getBridges() {
        return Collections.unmodifiableMap(bridges);
    }
}
