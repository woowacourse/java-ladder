package domain.strategy;

import domain.ladder.Bridge;

import java.util.List;

public class TestBridgeMakingStrategy extends BridgeMakingStrategy {
    private final List<Bridge> bridges;
    private int index = 0;

    public TestBridgeMakingStrategy(final List<Bridge> bridges) {
        this.bridges = bridges;
    }

    @Override
    public Bridge getFirst() {
        return makeBridge();
    }

    @Override
    protected Bridge makeBridge() {
        if (this.bridges.size() <= this.index) {
            throw new IllegalArgumentException("더이상 호출할 수 없습니다.");
        }

        return this.bridges.get(this.index++);
    }
}
