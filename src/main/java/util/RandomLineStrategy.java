package util;

import domain.Line;
import domain.Step;
import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public Line generate(int width) {
        return null;
    }

    private Step createRandomStep() {
        int number = random.nextInt(10);
        return null;
    }
}
