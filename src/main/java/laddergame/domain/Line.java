package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> line = new ArrayList<>();

    public Line(int width) {
        line.add(decideBooleanValueForLadder(false));
        for (int i = 1; i < width -1; i++) {
            line.add(decideBooleanValueForLadder(line.get(i-1)));
        }
    }

    private static boolean decideBooleanValueForLadder(boolean preValue) {
        if (preValue) return false;

        return new Random().nextBoolean();
    }

    public boolean getBooleanValue(int x) {
        return line.get(x);
    }

    public int getLineSize() {
        return line.size();
    }
}
