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

    public List<Bridge> generateLadder(Width width) {
        List<Bridge> ladder = new ArrayList<>();
        int maxWidth = width.getWidth();
        while (ladder.size() < maxWidth) {
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
