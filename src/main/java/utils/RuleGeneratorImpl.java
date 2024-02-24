package utils;

import java.util.Random;

public class RuleGeneratorImpl implements RuleGenerator {

    private static final int THRESHOLD = 3;

    @Override
    public boolean isAboveThreshold() {
        int randomNumber = new Random().nextInt(10);

        return randomNumber >= THRESHOLD;
    }
}
