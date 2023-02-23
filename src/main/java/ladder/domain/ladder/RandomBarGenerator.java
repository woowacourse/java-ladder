package ladder.domain.ladder;

import java.util.Random;

public class RandomBarGenerator implements BarGenerator {
    private final Random random = new Random();

    @Override
    public Bar generateBar() {
        return Bar.of(random.nextBoolean());
    }
}
