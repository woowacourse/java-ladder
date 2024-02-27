package domain.bridge.strategy;

import domain.ladder.LadderBridge;
import domain.ladder.strategy.BridgeGenerator;
import java.util.List;

public class BridgeGeneratorStub implements BridgeGenerator {
    private List<LadderBridge> bridges;

    public void setBridges(List<LadderBridge> bridges) {
        this.bridges = bridges;
    }

    @Override
    public List<LadderBridge> generate(int count) {
        return bridges;
    }
}
