package ladder.utils;

import java.util.Random;

import ladder.utils.BooleanGenerator;

public class RandomBooleanGenerator implements BooleanGenerator {

    Random random = new Random();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
