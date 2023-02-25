package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {
    private final Random random = new Random();

    @Override
    public List<Line> generate(final Width width, final Height height) {
        List<Line> ladder = new ArrayList<>();
        for (int floor = 0; floor < height.getHeight(); floor++) {
            ladder.add(makeLine(width));
        }
        return ladder;
    }

    private Line makeLine(final Width width) {
        List<Bridge> line = new ArrayList<>();
        int maxWidth = width.getWidth();
        while (line.size() < maxWidth) {
            line.add(generateBridge(line));
        }
        return new Line(line);
    }

    private Bridge generateBridge(final List<Bridge> result) {
        if (result.isEmpty() || !result.get(result.size() - 1).isExist()) {
            return Bridge.from(random.nextBoolean());
        }
        return Bridge.NON_EXIST;
    }
}
