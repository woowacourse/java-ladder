package utils;

import java.util.Random;

public class RuleGeneratorImpl implements RuleGenerator {

    private static final int THRESHOLD = 5;

    @Override
    public boolean generate() {
        int randomNumber = new Random().nextInt(10);

        return randomNumber >= THRESHOLD;
    }
}
