package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStepsGenerator implements StepsGenerator{
    private static Random random = new Random();
    private final int countOfPlayer;

    public RandomStepsGenerator(int countOfPlayer){
        this.countOfPlayer = countOfPlayer;
    }

    public Step getRandomStep() {
        return new Step(random.nextBoolean());
    }

    public Step getRandomStep(Step step) {
        return (step.exist()) ? new Step(false) : new Step(random.nextBoolean());
    }

    @Override
    public Steps generateSteps() {
        List<Step> steps = new ArrayList<>();

        steps.add(getRandomStep());
        for (int i = 1; i < countOfPlayer - 1; i++) {
            steps.add(getRandomStep(steps.get(i - 1)));
        }

        return new Steps(steps);
    }

    @Override
    public List<Steps> generateStepsList(int ladderHeight) {
        List<Steps> stepsList = new ArrayList<>();

        for (int i = 1; i < ladderHeight; i++) {
            stepsList.add(generateSteps());
        }

        return stepsList;
    }
}
