package ladder.domain.ladder.generator;

import java.util.Random;

public class RandomStrategy implements GenerateDirectionStrategy {

    private static final Random random = new Random();

    @Override
    public boolean creatable() {
        return random.nextInt(0, 3) == 0;
    }
}
