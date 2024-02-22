package domain;

import java.util.ArrayList;
import java.util.List;


public class LadderFactory {

    private final LadderStrategy ladderStrategy;

    public LadderFactory() {
        ladderStrategy = new RandomLadderStrategy();
    }

    public LadderFactory(LadderStrategy ladderStrategy) {
        this.ladderStrategy = ladderStrategy;
    }


    public List<Bridge> create(int width, int height) {
        List<Bridge> bridges = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width - 1; x++) {
                if (ladderStrategy.creatable()) {
                    bridges.add(new Bridge(x, y));
                }
            }
        }

        return discardOverlappedBridge(bridges);
    }

    private List<Bridge> discardOverlappedBridge(List<Bridge> bridges) {
        List<Bridge> remainBridges = new ArrayList<>();

        for (Bridge bridge : bridges) {
            boolean flag = false;
            for (Bridge bridge1 : remainBridges) {
                if (bridge.isAdjacent(bridge1)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                remainBridges.add(bridge);
            }
        }
        return remainBridges;
    }
}
