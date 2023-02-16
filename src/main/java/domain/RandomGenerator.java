package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private final Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    public List<Bridge> generateLadder(int bridgeCount) {
        List<Bridge> ladder = new ArrayList<>();
        while (ladder.size() < bridgeCount) {
            ladder.add(generateBridge(ladder));
        }
        return ladder;
    }

    private Bridge generateBridge(List<Bridge> result) {
//        result.get(result.size() - 1) == Bridge.NON_EXIST
        if (result.isEmpty() || !result.get(result.size() - 1).getIsExist()) {
            return Bridge.from(random.nextBoolean());
        }
        return Bridge.NON_EXIST;
    }
}
