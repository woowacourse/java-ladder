package domain.game;

import domain.ladder.Bridge;
import domain.ladder.Row;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class LadderClimber {

    public static List<Integer> climbDown(final Row row, final List<Integer> departure) {
        final List<Integer> arrival = new ArrayList<>(departure.get(0));
        for (final Bridge bridge : row.getBridges()) {
            arrival.add(departure.get(arrival.size()));
            swapLastIfBridgeContinuous(bridge, arrival);
        }
        return arrival;
    }

    private static void swapLastIfBridgeContinuous(final Bridge bridge, final List<Integer> to) {
        if (!bridge.isEmpty()) {
            return;
        }

        final int lastIndex = to.size() - 1;
        swap(to, lastIndex - 1, lastIndex);
    }
}
