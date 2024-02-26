package laddergame.util;

import laddergame.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

    private final Random random;

    public RandomLineGenerator() {
        this.random = new Random();
    }

    @Override
    public Line generate() {
        List<Line> lines = Arrays.stream(Line.values()).toList();
        int randomIndex = random.nextInt(lines.size());

        return lines.get(randomIndex);
    }
}
