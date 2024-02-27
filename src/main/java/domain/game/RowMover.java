package domain.game;

import domain.ladder.Bridge;
import domain.ladder.Row;

import java.util.ArrayList;
import java.util.List;

import static domain.ladder.Bridge.EMPTY;
import static java.util.Collections.swap;

public class RowMover {

    public static List<Integer> move(final Row row, final List<Integer> from) {
        final List<Integer> to = getModifiableListContainsElement(from.get(0));
        for (final Bridge bridge : row.getBridges()) {
            final Integer bridgeRightSideIndex = from.get(to.size());
            to.add(bridgeRightSideIndex);
            swapLastIfBridgeExist(bridge, to);
        }
        return to;
    }

    private static List<Integer> getModifiableListContainsElement(final Integer elem) {
        return new ArrayList<>(List.of(elem));
    }

    private static void swapLastIfBridgeExist(final Bridge bridge, final List<Integer> to) {
        if (bridge == EMPTY) {
            return;
        }

        final int lastIndex = to.size() - 1;
        swap(to, lastIndex - 1, lastIndex);
    }
}
