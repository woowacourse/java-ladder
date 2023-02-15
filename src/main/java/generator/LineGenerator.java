package generator;

import domain.Bridge;
import domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {

    private static final Random RANDOM = new Random();

    public static Line generate(int personCount) {
        List<Bridge> newBridges = new ArrayList<>();

        for (int i = 0; i < personCount - 1; i++) {
            newBridges.add(getNextBridge(newBridges));
        }

        return new Line(newBridges);
    }

    private static Bridge getNextBridge(List<Bridge> bridges) {
        if (hasLeftBridge(bridges)) {
            return Bridge.EMPTY;
        }
        return RANDOM.nextBoolean() ? Bridge.EXIST : Bridge.EMPTY;
    }

    private static boolean hasLeftBridge(List<Bridge> bridges) {
        if (bridges.isEmpty()) {
            return false;
        }
        return bridges.get(bridges.size() - 1) == Bridge.EXIST;
    }
}
