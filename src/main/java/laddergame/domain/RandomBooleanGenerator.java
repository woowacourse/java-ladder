package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private static final Random random = new Random();

    public RandomBooleanGenerator() {
    }

    @Override
    public List<Boolean> generateUntil(final int size) {
        // TODO : stream 변환
        List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            booleans.add(random.nextBoolean());
        }

        booleans.add(true);
        return booleans;
    }
}
