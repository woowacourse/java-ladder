package domain.ladder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Row {
    private final List<Bridge> bridges;

    public Row(final int width, final BridgeMakingStrategy strategy) {
        this.bridges = makeRow(width, strategy);
        // TODO: 연속한 다리가 있는지 확인
    }

    private List<Bridge> makeRow(final int width, final BridgeMakingStrategy strategy) {
        final List<Bridge> bridges = new ArrayList<>();
        Bridge current = null;
        for (int i = 0; i < width; i++) {
            current = strategy.getOne(current);
            bridges.add(current);
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
