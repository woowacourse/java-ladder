package ladder.domain.randomGenerator;

import java.util.Random;

public class RandomRungGenerator implements RungGenerator {

    @Override
    public boolean getRandomBooleanStatus() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
