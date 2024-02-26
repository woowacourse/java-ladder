package laddergame.util;

import laddergame.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomLinesGenerator implements LinesGenerator {

    private final Random random;

    public RandomLinesGenerator() {
        this.random = new Random();
    }

    @Override
    public List<Line> generate(final int width) {
        List<Line> lineStatus = new ArrayList<>();

        lineStatus.add(randomSelectLine());
        for (int i = 0; i < width - 1; i++) {
            Line beforeValue = lineStatus.get(lineStatus.size() -1);
            lineStatus.add(decideNextValue(beforeValue));
        }
        return lineStatus;
    }

    private Line randomSelectLine() {
        List<Line> lines = Arrays.stream(Line.values()).toList();
        int randomIndex = random.nextInt(lines.size());

        return lines.get(randomIndex);
    }

    private Line decideNextValue(Line beforeValue) {
        if (beforeValue.equals(Line.BRIDGE)) {
            return Line.EMPTY;
        }
        return randomSelectLine();
    }
}
