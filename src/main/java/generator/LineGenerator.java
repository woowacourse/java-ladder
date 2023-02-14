package generator;

import domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {

    private static final Random RANDOM = new Random();

    public static Line generateLine(int personCount) {
        List<Boolean> newBridges = new ArrayList<>();

        for (int i = 0; i < personCount - 1; i++) {
            newBridges.add(getNextBridge(newBridges));
        }

        return new Line(newBridges);
    }

    private static boolean getNextBridge(List<Boolean> bridges) {
        if (hasLeftBridge(bridges)) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    private static boolean hasLeftBridge(List<Boolean> bridges) {
        if (bridges.isEmpty()) {
            return false;
        }
        return bridges.get(bridges.size() - 1);
    }
}
