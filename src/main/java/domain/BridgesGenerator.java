package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgesGenerator {
    private final BridgeGenerator bridgeGenerator;

    public BridgesGenerator(BridgeGenerator bridgeGenerator) {
        this.bridgeGenerator = bridgeGenerator;
    }
    
    public Bridges generate(int width) {
        List<Boolean> bridges = new ArrayList<>();
        boolean previousBridge = false;
        for (int i = 0; i < width; i++) {
            previousBridge = nextBridge(previousBridge);
            bridges.add(previousBridge);
        }
        return new Bridges(Collections.unmodifiableList(bridges));
    }

    private Boolean nextBridge(boolean previousBridge) {
        Boolean bridge = bridgeGenerator.generate();
        if (previousBridge && bridge) {
            return false;
        }
        return bridge;
    }
}
