package ladder.domain.randomGenerator;

import java.util.Random;

public class RandomRungGenerator implements RungGenerator {

    private static final Random random = new Random();

    @Override
    public boolean getRandomBooleanStatus() {
        return random.nextBoolean();
    }
}
