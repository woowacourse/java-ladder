package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LIneGenerator {
    protected static List<Boolean> makeLine(int width) {
        List<Boolean> line = new ArrayList<>();

        line.add(getConnectableValue(false));
        for (int i = 1; i < width-1; i++) {
            line.add(getConnectableValue(line.get(i-1)));
        }

        return line;
    }

    private static boolean getConnectableValue(boolean preValue) {
        if (preValue) return false;

        return new Random().nextBoolean();
    }
}
