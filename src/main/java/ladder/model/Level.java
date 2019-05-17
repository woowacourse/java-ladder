package ladder.model;

import ladder.model.Coin.Coin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private static int DRAW = 2;
    private static int PASS = 1;
    private final List<Integer> lines;

    public Level(int width, Coin possibility) {
        lines = drawOrPass(0, width, possibility, new ArrayList<>());
    }

    private List<Integer> drawOrPass(int target, int left, Coin possibility, List<Integer> acc) {
        if (possibility.toss() && left > 0) {
            acc.add(target);
            return drawOrPass(target + DRAW, left - DRAW, possibility, acc);
        }
        if (left > 0) {
            return drawOrPass(target + PASS, left - PASS, possibility, acc);
        }
        return Collections.unmodifiableList(acc);
    }

    public List<Integer> getLines() {
        return lines;
    }
}