package ladder.domain.valueGenerator;

import java.util.Random;

public class RandomIntegerGenerator implements  IntegerGenerator{

    private final Random random;

    public RandomIntegerGenerator() {
        this.random = new Random();
    }

    @Override
    public int generateNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

}
