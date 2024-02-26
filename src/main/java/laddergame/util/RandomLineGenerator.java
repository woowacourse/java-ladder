package laddergame.util;

import laddergame.domain.Line;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

    private final Random random;

    public RandomLineGenerator() {
        this.random = new Random();
    }

    @Override
    public Line generate() {
        return Line.getLine(random.nextBoolean());
    }
}
