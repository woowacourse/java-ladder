package domain.game;

import domain.ladder.Bridge;
import domain.ladder.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineMover {
    private final List<Integer> result = new ArrayList<>();

    public LineMover(final Line line, final List<Integer> input) {
        move(line, input);
    }

    public List<Integer> getResult() {
        return Collections.unmodifiableList(result);
    }

    private void move(final Line line, final List<Integer> input) {
        this.result.add(input.get(0));
        for (Bridge bridge : line.getBridges()) {
            result.add(input.get(result.size()));
            swapIfBridgeExist(bridge);
        }
    }

    private void swapIfBridgeExist(final Bridge bridge) {
        if (bridge == Bridge.EXIST) {
            int lastIndex = this.result.size() - 1;
            Collections.swap(result, lastIndex - 1, lastIndex);
        }
    }
}
