package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private static final Random random = new Random();

    private final int size;

    public RandomBooleanGenerator(final int size) {
        this.size = size;
    }

    @Override
    public List<Boolean> generate() {
        List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            booleans.add(random.nextBoolean());
        }

        return booleans;
    }
}
