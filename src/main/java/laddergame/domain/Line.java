package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> line = new ArrayList<>();

    public Line(int width) {
        line.add(getBooleanValueForLadder(false));
        for (int i = 1; i < width -1; i++) {
            line.add(getBooleanValueForLadder(line.get(i-1)));
        }
    }

    private static boolean getBooleanValueForLadder(boolean preValue) {
        if (preValue) return false;

        return new Random().nextBoolean();
    }

}
