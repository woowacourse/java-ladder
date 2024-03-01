package domain.bridge.strategy;

import domain.bridge.BridgeGenerator;
import domain.ladder.LadderBridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGeneratorStub implements BridgeGenerator {
    private List<LadderBridge> bridges;

    public void setBridges(final List<LadderBridge> bridges) {
        this.bridges = bridges;
    }

    public BridgeGeneratorStub() {
        this.bridges = new ArrayList<>();
    }

    @Override
    public List<LadderBridge> generate(final int count) {
        return bridges;
    }
}
