package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.StepStatusDto;

public class Line {

    private static final int STEP_START_NUMBER = 0;

    private static final boolean DEFAULT_NO_DUPLICATED_STEP = false;

    private final List<Step> steps;

    public Line(final int personCount) {
        this.steps = makeSteps(personCount);
    }

    public StepStatusDto getSteps() {
        return new StepStatusDto(steps);
    }

    public void buildSteps(int currentPosition) {
        steps.get(currentPosition).build();
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
