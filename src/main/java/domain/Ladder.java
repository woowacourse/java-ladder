package domain;

import java.util.ArrayList;
import java.util.List;


public class Ladder {

    private final LadderStrategy ladderStrategy;
    private final List<Bridge> bridges;

    Ladder(final LadderStrategy ladderStrategy, final int width, final int height) {
        this.ladderStrategy = ladderStrategy;
        this.bridges = new ArrayList<>();
        create(width, height);
    }

    public Ladder(final int width, final int height) {
        this(new RandomLadderStrategy(), width, height);
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    private void create(final int ladderWidth, final int ladderHeight) {
        for (int height = 0; height < ladderHeight; height++) {
            createSingleLine(ladderWidth, height);
        }
    }

    private void createSingleLine(final int width, final int height) {
        for (int rail = 0; rail < width - 1; rail++) {
            createSingleBridge(rail, height);
        }
    }

    private void createSingleBridge(final int rail, final int height) {
        if (!existPreviousBridge(rail, height) && ladderStrategy.creatable()) {
            bridges.add(new Bridge(rail, height));
        }
    }
    private boolean existPreviousBridge(final int rail, final int height) {
        if (bridges.isEmpty()) {
            return false;
        }
        final Bridge lastBridge = bridges.get(bridges.size() - 1);
        return lastBridge.isAdjacent(new Bridge(rail, height));
    }
}
