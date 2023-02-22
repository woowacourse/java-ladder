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

    public List<Bridge> generateLine(Width width) {
        List<Bridge> line = new ArrayList<>();
        int maxWidth = width.getWidth();
        while (line.size() < maxWidth) {
            line.add(generateBridge(line));
        }
        return line;
    }

    private Bridge generateBridge(List<Bridge> result) {
        if (result.isEmpty() || !result.get(result.size() - 1).isExist()) {
            return Bridge.from(random.nextBoolean());
        }
        return Bridge.NON_EXIST;
    }
}
