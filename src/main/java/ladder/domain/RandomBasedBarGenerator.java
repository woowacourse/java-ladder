package ladder.domain;

import java.util.Random;

public class RandomBasedBarGenerator implements BarGenerator {
    @Override
    public boolean createBar() {
        return new Random().nextBoolean();
    }
}
