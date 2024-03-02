package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RowGenerator {
    private final BridgeGenerator bridgeGenerator;

    public RowGenerator(BridgeGenerator bridgeGenerator) {
        this.bridgeGenerator = bridgeGenerator;
    }

    public Row generate(int width) {
        List<Bridge> bridges = new ArrayList<>();
        Bridge previousBridge = Bridge.NONE;
        for (int i = 0; i < width; i++) {
            previousBridge = nextBridge(previousBridge);
            bridges.add(previousBridge);
        }
        return new Row(Collections.unmodifiableList(bridges));
    }

    private Bridge nextBridge(Bridge previousBridge) {
        Bridge bridge = bridgeGenerator.generate();
        if (previousBridge == Bridge.EXIST && bridge == Bridge.EXIST) {
            return Bridge.NONE;
        }
        return bridge;
    }
}
