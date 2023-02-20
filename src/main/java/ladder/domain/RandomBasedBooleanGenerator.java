package ladder.domain;

import java.util.Random;

public class RandomBasedBooleanGenerator implements BooleanGenerator {
    private static final Random RANDOM = new Random();
    
    @Override
    public boolean createBoolean() {
        return RANDOM.nextBoolean();
    }
}
