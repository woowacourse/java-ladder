package ladder.domain;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator{

    @Override
    public Boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
