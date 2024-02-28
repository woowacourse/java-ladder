package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StepsGenerator {
    private static final Random random = new Random();

    public static Layer generate(int numberOfParticipants) {
        List<Step> steps = new ArrayList<>();
        boolean priorExistence = false;
        for (int i = 1; i < numberOfParticipants; i++) {
            boolean doesExist = generateExistence(priorExistence);
            priorExistence = doesExist;
            steps.add(Step.findByExistence(doesExist));
        }
        return new Layer(steps);
    }

    public static boolean generateExistence(boolean priorExistence) {
        if (priorExistence) {
            return false;
        }
        return random.nextBoolean();
    }
}
