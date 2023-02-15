package utils.booleanGenerator;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
