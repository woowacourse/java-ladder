package model;

import java.util.Random;

public class StepGenerator {
    Random random = new Random();

    public boolean generateStep(boolean beforeValue) {
        if (beforeValue) {
            return false;
        }
        return random.nextBoolean();
    }
}