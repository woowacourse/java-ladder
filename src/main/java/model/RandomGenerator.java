package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    public List<Boolean> generate(int count) {
        List<Boolean> results = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            results.add(random.nextBoolean());
        }
        return results;
    }
}
