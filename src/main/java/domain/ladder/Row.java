package domain.ladder;

import domain.strategy.BridgeMakingStrategy;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Row {
    private final List<Bridge> bridges;

    public Row(final int width, final BridgeMakingStrategy strategy) {
        this.bridges = makeBridges(width, strategy);
    }

    private List<Bridge> makeBridges(final int width, final BridgeMakingStrategy strategy) {
        final List<Bridge> bridges = new ArrayList<>(List.of(strategy.getFirst()));
        for (int i = 1; i < width; i++) {
            final Bridge previous = bridges.get(bridges.size() - 1);
            bridges.add(strategy.get(previous));
        }
        return bridges;
    }

    public List<Bridge> getBridges() {
        return unmodifiableList(this.bridges);
    }

    public int getWidth() {
        return this.bridges.size();
    }
}
