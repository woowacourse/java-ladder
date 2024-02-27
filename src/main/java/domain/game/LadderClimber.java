package domain.game;

import domain.ladder.Bridge;
import domain.ladder.Row;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class LadderClimber {

    public static List<Integer> climbDown(final Row row, final List<Integer> from) {
        final List<Integer> to = getModifiableListContainsElement(from.get(0));
        for (final Bridge bridge : row.getBridges()) {
            final Integer rightIdx = from.get(to.size());
            to.add(rightIdx);
            swapLastIfBridgeContinuous(bridge, to);
        }
        return to;
    }

    private static List<Integer> getModifiableListContainsElement(final Integer elem) {
        return new ArrayList<>(List.of(elem));
    }

    private static void swapLastIfBridgeContinuous(final Bridge bridge, final List<Integer> to) {
        if (!bridge.isExist()) {
            return;
        }

        final int lastIndex = to.size() - 1;
        swap(to, lastIndex - 1, lastIndex);
    }
}
