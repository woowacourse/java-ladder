package ladder.domain;

import java.util.Random;

public class RandomBasedBarGenerator implements BarGenerator {
    private static final Random RANDOM = new Random();
    
    @Override
    public Bar createBar() {
        return Bar.valueOfBar(getRandomBoolean());
    }
    
    private boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}
