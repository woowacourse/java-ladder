package domain.ladder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Row {
    private final List<Bridge> bridges;

    public Row(final int width, final BridgeMakingStrategy strategy) {
        this.bridges = makeRow(width, strategy);
        validateRow();
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

    private void validateRow() {
        for (int current = 1; current < this.bridges.size(); current++) {
            checkContinuousBridge(bridges.get(current - 1), bridges.get(current));
        }
    }

    private void checkContinuousBridge(final Bridge previous, final Bridge current) {
        if (previous.isExist() && current.isExist()) {
            throw new IllegalArgumentException("연속된 다리가 존재합니다.");
        }
    }

    public List<Bridge> getBridges() {
        return unmodifiableList(this.bridges);
    }

    public int getWidth() {
        return this.bridges.size();
    }
}
