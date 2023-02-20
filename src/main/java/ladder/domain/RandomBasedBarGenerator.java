package ladder.domain;

import java.util.Random;

public class RandomBasedBarGenerator implements BarGenerator {
    private final Random random = new Random();

    @Override
    public boolean createBar() {
        return random.nextBoolean();
    }
}
