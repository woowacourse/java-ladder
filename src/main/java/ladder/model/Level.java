package ladder.model;

import ladder.model.Coin.Coin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final List<Integer> verticalLines;

    public Level(int width, Coin possibility) {
        verticalLines = drawOrPass(0, width, possibility, new ArrayList<>());
    }

    private List<Integer> drawOrPass(int target, int left, Coin possibility, List<Integer> acc) {
        if (possibility.toss() && left > 0) {
            acc.add(target);
            return drawOrPass(target + 2, left - 2, possibility, acc);
        }
        if (left > 0) {
            return drawOrPass(target + 1, left - 1, possibility, acc);
        }
        return Collections.unmodifiableList(acc);
    }

    public List<Integer> getVerticalLines() {
        return verticalLines;
    }
}