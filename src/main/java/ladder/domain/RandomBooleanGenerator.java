package ladder.domain;

import java.util.Random;

public class RandomBooleanGenerator implements RandomGenerator<Boolean>{
    @Override
    public Boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
