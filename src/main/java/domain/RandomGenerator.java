package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private final Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    public List<Boolean> generateLadder(int bridgeCount) {
        List<Boolean> ladder = new ArrayList<>();
        while (ladder.size() < bridgeCount) {
            ladder.add(generateBridge(ladder));
        }
        return ladder;
    }

    private boolean generateBridge(List<Boolean> result) {
        if (result.isEmpty() || !result.get(result.size() - 1)) {
            return random.nextBoolean();
        }
        return false;
    }
}
