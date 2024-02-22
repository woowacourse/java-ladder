package model;

import java.util.Random;

public class StepGenerator {
    static Random random = new Random();

    public static boolean generateStep(boolean beforeValue) {
        if (beforeValue) {
            return false;
        }
        return random.nextBoolean();
    }
}