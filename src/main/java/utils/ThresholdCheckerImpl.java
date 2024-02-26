package utils;

import java.util.Random;

public class ThresholdCheckerImpl implements ThresholdChecker {

    private static final int THRESHOLD = 3;

    @Override
    public boolean isAboveThreshold() {
        int randomNumber = new Random().nextInt(10);

        return randomNumber >= THRESHOLD;
    }
}
