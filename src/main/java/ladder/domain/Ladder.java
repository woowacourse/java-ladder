package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.BuiltLadderDto;

public class Ladder {

    private static final boolean DEFAULT_NO_DUPLICATED_STEP = false;

    private final List<Step> steps;

    public Ladder(final int personCount) {
        this.steps = makeSteps(personCount);
    }

    private List<Step> makeSteps(int stepCount) {
        List<Step> steps = new ArrayList<>();

        for (int i = 0; i < stepCount; i++) {
            steps.add(new Step());
        }
        return steps;
    }

    public BuiltLadderDto getSteps() {
        return BuiltLadderDto.of(steps);
    }

    public void buildSteps(int currentPosition) {
        steps.get(currentPosition).changeStatus();
    }

    public boolean hasStepDuplicated(int currentPosition) {
        if (currentPosition > 0) {
            Step step = steps.get(currentPosition - 1);
            return step.getBuildStatus();
        }
        return DEFAULT_NO_DUPLICATED_STEP;
    }
}
