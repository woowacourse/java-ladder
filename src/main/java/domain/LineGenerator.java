package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    private final Random random = new Random();
    private static final LineGenerator INSTANCE = new LineGenerator();

    public static LineGenerator getInstance() {
        return INSTANCE;
    }

    public List<Bridge> generateLadder(int width) {
        validateBridgeCountRange(width);
        List<Bridge> ladder = new ArrayList<>();
        while (ladder.size() < width) {
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

    private void validateBridgeCountRange(int bridgeCount) {
        if (bridgeCount > 9 || bridgeCount < 1) {
            throw new IllegalArgumentException("");
        }
    }
}
