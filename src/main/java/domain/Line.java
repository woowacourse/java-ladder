package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private static final Random random = new Random();
    private final List<Boolean> bridges;

    public Line(final int width) {
        bridges = generateLine(width);
    }

    public List<Boolean> getBridges() {
        return bridges;
    }

    private List<Boolean> generateLine(final int width) {
        List<Boolean> bridges = IntStream.range(0, width)
                .mapToObj(ignore -> random.nextBoolean())
                .toList();
        return filterAdjacentBridges(bridges);
    }

    private List<Boolean> filterAdjacentBridges(final List<Boolean> bridges) {
        List<Boolean> filteredBridges = new ArrayList<>();
        for (int current = 1; current < bridges.size(); current++) {
            Boolean beforeBridge = bridges.get(current - 1);
            Boolean currentBridge = bridges.get(current);
            filteredBridges.add(removeBridgeIfAdjacent(beforeBridge, currentBridge));
        }
        return filteredBridges;
    }

    private boolean removeBridgeIfAdjacent(final Boolean before, final Boolean current) {
        if (before && current) {
            return false;
        }
        return current;
    }
}
