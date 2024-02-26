package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private final Random random = new Random();

    public List<Boolean> generate(int count) {
        List<Boolean> results = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            results.add(random.nextBoolean());
        }
        return results;
    }
}
