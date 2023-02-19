package ladder.domain;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator{

    Random random = new Random();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
