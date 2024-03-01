package domain.strategy;

import domain.ladder.Bridge;

import java.util.List;

public class TestBridgeMakingStrategy extends BridgeMakingStrategy {
    private final List<Bridge> bridges;
    private int index = -1;

    public TestBridgeMakingStrategy(final List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public Bridge get(final Bridge previous) {
        increaseIndex();

        if (this.bridges.size() <= this.index) {
            throw new IllegalArgumentException("더이상 호출할 수 없습니다.");
        }

        return super.get(previous);
    }

    private void increaseIndex() {
        this.index++;
    }

    @Override
    public Bridge get() {
        increaseIndex();
        return makeBridge();
    }

    @Override
    protected Bridge makeBridge() {
        return this.bridges.get(this.index);
    }
}
