package domain;

import domain.ladder.Bridge;
import domain.ladder.BridgeMakingStrategy;

import java.util.List;

public class TestBridgeMakingStrategy implements BridgeMakingStrategy {

    private final List<Bridge> bridges;
    private int index = 0;

    public TestBridgeMakingStrategy(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    @Override
    public Bridge getOne(final Bridge previous) {
        if (index >= bridges.size()) {
            throw new IllegalArgumentException("더이상 호출할 수 없습니다.");
        }
        return bridges.get(index++);
    }
}
