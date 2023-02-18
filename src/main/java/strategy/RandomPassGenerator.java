package strategy;

import java.util.Random;

public class RandomPassGenerator implements PassGenerator {

    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
