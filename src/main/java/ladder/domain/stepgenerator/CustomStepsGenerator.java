package ladder.domain.stepgenerator;

import ladder.domain.laddercomponent.Step;
import ladder.domain.laddercomponent.Steps;

import java.util.ArrayList;
import java.util.List;

public class CustomStepsGenerator implements StepsGenerator {
    private final List<Steps> stepsList;

    public CustomStepsGenerator() {
        this.stepsList = new ArrayList<>();
    }

    public void addCustomStpes(List<Boolean> stepExists) {
        List<Step> steps = new ArrayList<>();

        for (Boolean stepExist : stepExists) {
            steps.add(new Step(stepExist));
        }
        stepsList.add(new Steps(steps));
    }

    @Override
    public Steps generateSteps() {
        return null;
    }

    @Override
    public List<Steps> generateStepsList(int ladderHeight) {
        return stepsList.subList(0, ladderHeight);
    }
}
