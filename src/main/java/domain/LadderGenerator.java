package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    private final Random random;

    public LadderGenerator() {
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
        if (result.isEmpty() || !result.get(result.size() - 1).isExist()) {
            return Bridge.from(random.nextBoolean());
        }
        return Bridge.NON_EXIST;
    }
}
