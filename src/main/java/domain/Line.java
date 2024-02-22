package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        for (int i = 1; i < bridges.size(); i++) {
            Boolean before = bridges.get(i - 1);
            Boolean current = bridges.get(i);
            filteredBridges.add(removeBridgeIfAdjacent(before, current));
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
