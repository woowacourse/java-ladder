package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {
    private final Random random = new Random();

    @Override
    public Ladder generate(final int width, final Height height) {
        List<Line> lines = new ArrayList<>();
        for (int floor = 0; floor < height.getHeight(); floor++) {
            lines.add(makeLine(width));
        }
        return new Ladder(lines);
    }

    private Line makeLine(final int width) {
        List<Bridge> line = new ArrayList<>();
        while (line.size() < width) {
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
