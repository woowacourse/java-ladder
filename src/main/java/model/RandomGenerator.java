package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private final Random random = new Random();

    public List<List<Boolean>> generateBooleans(int height, int count) {
        List<List<Boolean>> booleans = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            booleans.add(createBoolean(count));
        }
        return booleans;
    }

    private List<Boolean> createBoolean(int count) {
        List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(random.nextBoolean());
        }
        return results;
    }
}
