package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineMaker implements LineMaker {
    private static final int BOUND = 1;

    private final Random random;

    public RandomLineMaker() {
        this.random = new Random();
    }

    @Override
    public List<Boolean> generateLine(int userCount) {
        List<Boolean> points = new ArrayList<>();
        for (int point = 1; point < userCount; point++) {
            points.add(generateNumber(BOUND + 1));
        }

        return points;
    }

    public boolean generateNumber(int bound) {
        return random.nextInt(bound) == BOUND;
    }
}
