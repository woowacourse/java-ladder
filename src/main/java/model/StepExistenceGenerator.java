package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StepExistenceGenerator {
    private static final Random random = new Random();

    public static List<Step> generate(int numberOfParticipants) {
        List<Step> steps = new ArrayList<>();
        boolean priorExistence = false;

        for (int i = 1; i < numberOfParticipants; i++) {
            boolean doesExist = generateEachExistence(priorExistence);
            priorExistence = doesExist;
            steps.add(Step.findByExistence(doesExist));
        }
        return steps;
    }

    public static boolean generateEachExistence(boolean priorExistence) {
        if (priorExistence) {
            return false;
        }
        return random.nextBoolean();
    }
}
