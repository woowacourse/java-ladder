package domain.game;

import domain.ladder.Bridge;
import domain.ladder.Row;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderClimber {

    public static List<Integer> climbDownRow(final List<Integer> departure, final Row row) {
        final List<Integer> arrival = new ArrayList<>(List.of(departure.get(0)));
        for (final Bridge bridge : row.getBridges()) {
            addBridge(departure, arrival, bridge);
        }
        return arrival;
    }

    private static void addBridge(final List<Integer> departure, final List<Integer> arrival, final Bridge bridge) {
        arrival.add(departure.get(arrival.size()));
        swapLastIfBridgeContinuous(bridge, arrival);
    }

    private static void swapLastIfBridgeContinuous(final Bridge bridge, final List<Integer> arrival) {
        if (bridge.isEmpty()) {
            return;
        }

        final int lastIndex = arrival.size() - 1;
        Collections.swap(arrival, lastIndex - 1, lastIndex);
    }
}
