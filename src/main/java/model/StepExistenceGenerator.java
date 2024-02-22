package model;

import java.util.Random;

public class StepExistenceGenerator {
    private static Random random = new Random();

    public static boolean generate(boolean priorExistence) {
        if (priorExistence) {
            return false;
        }
        return random.nextBoolean();
    }
}
