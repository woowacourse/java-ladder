package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    private static boolean FIRST_VALUE_OF_LINE = false;

    protected static Line makeLine(int width) {
        List<Boolean> line = new ArrayList<>();

        line.add(getConnectableValue(FIRST_VALUE_OF_LINE));
        for (int i = 1; i < width-1; i++) {
            line.add(getConnectableValue(line.get(i-1)));
        }

        return new Line(line);
    }

    private static boolean getConnectableValue(boolean preValue) {
        if (preValue) return false;

        return new Random().nextBoolean();
    }
}
