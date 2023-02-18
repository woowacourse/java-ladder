package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator implements Generator<Bridge> {
    private final Random random;
    private final int bridgeCount;

    public LadderGenerator(int bridgeCount) {
        this.random = new Random();
        this.bridgeCount=bridgeCount;
    }

    @Override
    public List<Bridge> generate() {
        List<Bridge> ladder = new ArrayList<>();
        while (ladder.size() < bridgeCount) {
            ladder.add(generateBridge(ladder));
        }
        return ladder;
    }

    private Bridge generateBridge(List<Bridge> result) {
        if (generateCondition(result)) {
            return Bridge.from(random.nextBoolean());
        }
        return Bridge.NON_EXIST;
    }

    private boolean generateCondition(List<Bridge> result) {
        if (result.isEmpty() || !result.get(result.size() - 1).isExist()) {
            return true;
        }
        return false;
    }
}
