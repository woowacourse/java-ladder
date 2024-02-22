package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.BuiltLadderDto;

public class Ladder {

    private static final int STEP_START_NUMBER = 0;
    private static final boolean DEFAULT_NO_DUPLICATED_STEP = false;

    private final List<Step> steps;

    public Ladder(final int personCount) {
        this.steps = makeSteps(personCount);
    }

    public BuiltLadderDto getSteps() {
        return BuiltLadderDto.of(steps);
    }

    public void buildSteps(int currentPosition) {
        steps.get(currentPosition).changeStatus();
    }

    public boolean hasStepDuplicated(int currentPosition) {
        if (currentPosition > STEP_START_NUMBER) {
            int stepBeforePosition = currentPosition - 1;
            Step step = steps.get(stepBeforePosition);
            return step.getBuildStatus();
        }
        return DEFAULT_NO_DUPLICATED_STEP;
    }

    private List<Step> makeSteps(int stepCount) {
        List<Step> steps = new ArrayList<>();

        for (int currentStep = STEP_START_NUMBER; currentStep < stepCount; currentStep++) {
            steps.add(new Step());
        }
        return steps;
    }
}
