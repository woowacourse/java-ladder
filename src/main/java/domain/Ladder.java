package domain;

import java.util.ArrayList;
import java.util.List;


public class Ladder {
    private final LadderStrategy ladderStrategy;
    private final List<Bridge> bridges;

    Ladder(final LadderStrategy ladderStrategy, final int width, final int height) {
        this.ladderStrategy = ladderStrategy;
        bridges = create(width, height);
    }

    public Ladder(final int width, final int height) {
        this(new RandomLadderStrategy(), width, height);
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public List<Bridge> create(final int ladderWidth, final int ladderHeight) {
        List<Bridge> bridges = new ArrayList<>();
        for (int height = 0; height < ladderHeight; height++) {
            createSingleLine(bridges, ladderWidth, height);
        }
        filterAdjacentBridges(bridges);
        return bridges;
    }

    private void createSingleLine(final List<Bridge> bridges, final int width, final int height) {
        for (int rail = 0; rail < width - 1; rail++) {
            createSingleBridge(bridges, rail, height);
        }
    }

    private void createSingleBridge(final List<Bridge> bridges, final int rail, final int height) {
        if (ladderStrategy.creatable()) {
            bridges.add(new Bridge(rail, height));
        }
    }

    private void filterAdjacentBridges(final List<Bridge> bridges) {
        for (int index = 0; index < bridges.size() - 1; index++) {
            removeIfAdjacent(bridges, index);
        }
    }

    private static void removeIfAdjacent(final List<Bridge> bridges, final int index) {
        if (bridges.get(index).isAdjacent(bridges.get(index + 1))) {
            bridges.remove(index + 1);
        }
    }
}
