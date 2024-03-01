package domain;

import domain.ladder.Bridge;
import domain.strategy.BridgeMakingStrategy;

import java.util.List;

public class TestBridgeMakingStrategy extends BridgeMakingStrategy {

    private final List<Bridge> bridges;
    private int index = 0;

    public TestBridgeMakingStrategy(final List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public Bridge get(final Bridge previous) {
        if (this.bridges.size() <= this.index) {
            throw new IllegalArgumentException("더이상 호출할 수 없습니다.");
        }

        return makeBridge();
    }

    @Override
    public Bridge get() {
        return makeBridge();
    }

    @Override
    protected Bridge makeBridge() {
        return this.bridges.get(this.index++);
    }
}
