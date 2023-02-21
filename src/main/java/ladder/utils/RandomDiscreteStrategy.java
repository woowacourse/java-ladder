package ladder.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDiscreteStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public List<Boolean> generate(int bridgeCount) {
        return makeRandomLine(bridgeCount);
    }

    private List<Boolean> makeRandomLine(int bridgeCount) {
        List<Boolean> line = new ArrayList<>();

        boolean currentBridge = false;
        for (int i = 0; i < bridgeCount; i++) {
            currentBridge = getRandomBridge(currentBridge);
            line.add(currentBridge);
        }
        return line;
    }

    private boolean getRandomBridge(boolean previous) {
        if (previous == true) {
            return false;
        }
        return random.nextBoolean();
    }
}
