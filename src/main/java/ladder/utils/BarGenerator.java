package ladder.utils;

import java.util.Random;

public class BarGenerator implements BooleanGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}
