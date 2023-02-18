package ladder.domain;

import java.util.Random;

public class RandomBasedBarGenerator implements BarGenerator {
    private static final Random RANDOM = new Random();
    
    @Override
    public boolean createBar() {
        return RANDOM.nextBoolean();
    }
}
