package model;

import java.util.Random;

public class StepGenerator {
    private static Random random = new Random();

    public static boolean generateStep(boolean previousStep) {
        if (previousStep) {
            return false;
        }
        return random.nextBoolean();
    }
}