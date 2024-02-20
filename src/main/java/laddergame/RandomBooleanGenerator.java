package laddergame;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator{

    private static Random random = new Random();
    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
